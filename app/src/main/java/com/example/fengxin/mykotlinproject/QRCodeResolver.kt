package com.example.fengxin.mykotlinproject

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.google.zxing.BinaryBitmap
import com.google.zxing.MultiFormatReader
import com.google.zxing.RGBLuminanceSource
import com.google.zxing.common.HybridBinarizer
import java.io.InputStream

/**
 * Created by fengxin on 23/02/2018.
 */
internal object QRCodeResolver {

    private val TAG = "QRCodeResolver"

    fun scanQRImage(qrImageStream:InputStream) :String? {
        val bitmap = BitmapFactory.decodeStream(qrImageStream)
        return scanQRImage(bitmap)
    }

    fun scanQRImage(qrImage:Bitmap) :String? {
        var contents: String ? = null

        val intArray = IntArray(qrImage.width * qrImage.height)

        qrImage.getPixels(intArray,0,qrImage.width,0,0,qrImage.width,qrImage.height)

        val source = RGBLuminanceSource(qrImage.width,qrImage.height,intArray)

        val bitmap = BinaryBitmap(HybridBinarizer(source))
        val reader = MultiFormatReader()
        try {
            val result = reader.decode(bitmap)
            contents = result.text

        } catch (e:Exception) {
            Log.e(TAG,"Error decoding barcode",e)
        }
        return contents
    }

}