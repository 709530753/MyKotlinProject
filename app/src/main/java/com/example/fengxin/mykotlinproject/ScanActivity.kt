package com.example.fengxin.mykotlinproject

import android.app.Activity
import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView
import java.io.FileNotFoundException
import com.example.fengxin.mykotlinproject.ToastExtension.toast

class ScanActivity : Activity(),ZXingScannerView.ResultHandler,View.OnClickListener {


    private var scannerview: ZXingScannerView? = null
    private var flashStateView:ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)

        scannerview = findViewById<View>(R.id.zxing_scanner_view) as ZXingScannerView
        findViewById<View>(R.id.gallery_ib).setOnClickListener(this)
        flashStateView = findViewById<View>(R.id.flash_ib) as ImageButton
        flashStateView!!.setOnClickListener(this)

    }

    private fun resumeFlashState() {
        if (scannerview!!.flash) {
            flashStateView!!.setImageResource(R.drawable.tooltip_frame_light)
        } else {
            flashStateView!!.setImageResource(R.drawable.tooltip_frame_dark)
        }
    }

    override fun onClick(view: View) {
        Toast.makeText(this,"scanner : ",Toast.LENGTH_LONG).show()
        if (view.id == R.id.flash_ib) {
            scannerview!!.flash = !scannerview!!.flash
            resumeFlashState()
        } else if (view.id == R.id.gallery_ib) {
            var intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent,"Selected Picture"),REQUEST_PICK_IMAGE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        Log.e("ScanActivity : ", "" + resultCode)
        Log.e("ScanActivity : ", "" + data)

        if (requestCode == REQUEST_PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                return
            }

            try {
                val inputStream = contentResolver.openInputStream(data.data!!)
                var result = QRCodeResolver.scanQRImage(inputStream)
                if (result != null) {
                    toast(result)
                    finishScanner(result)
                } else {
                    Toast.makeText(this,"wrong qrcode format",Toast.LENGTH_SHORT).show()
                }
            } catch (ignore:FileNotFoundException) {

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun onResume() {
        super.onResume()
        scannerview!!.setResultHandler(this)
        scannerview!!.startCamera()
        resumeFlashState()
    }

    override fun onPause() {
        super.onPause()
        scannerview!!.setResultHandler(null)
        scannerview!!.stopCamera()
    }

    override fun handleResult(rawResult: Result) {
        finishScanner(rawResult.text)
    }

    private fun finishScanner(result:String) {
        val handler = Handler()
        handler.postDelayed({
            scannerview!!.resumeCameraPreview(this@ScanActivity)
            val data = Intent()
            data.putExtra(SCAN_RESULT,result)
            this@ScanActivity.setResult(Activity.RESULT_OK,data)
            this@ScanActivity.finish()
        },2000)
    }

    companion object {
        private val REQUEST_PICK_IMAGE = 100
        private val SCAN_RESULT = "key_scan_result"

        fun getResult(data: Intent?): String? {
            return data?.getStringExtra(ScanActivity.SCAN_RESULT)
        }

        fun scanQRCodeForResult(context: Activity,resultCode:Int) {
            val intent = Intent(context,ScanActivity::class.java)
            context.startActivityForResult(intent,resultCode)
        }

        fun scanQRCodeForResult(context: Fragment,resultCode:Int) {
            val intent = Intent(context.activity,ScanActivity::class.java)
            context.startActivityForResult(intent,resultCode)
        }

    }

}
