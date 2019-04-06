package com.alibaba.cloud.demo;
/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import com.alibaba.cloud.faceengine.Error;
import com.alibaba.cloud.faceengine.*;
/**
 * 线下SDK人脸对比demo
 */
public class FaceVerifyDemo {
    private static int RunMode = Mode.TERMINAL;

    public static void main(String[] args) {
        //step 1: authorize or enable debug
        FaceEngine.enableDebug(false);
        System.out.println("VENDOR_KEY : " + Utils.VENDOR_KEY);
        int error = FaceEngine.authorize(Utils.VENDOR_KEY);
        if (error != Error.OK) {
            System.out.println("authorize error : " + error);
            return;
        } else {
            System.out.println("authorize OK");
        }

        //1:1 face verify
        verifyPicture();
    }

    private static void verifyPicture() {
        System.out.println("verifyPicture begin");

        //verifyPicture step1: create FaceVerify, mode type can be TERMINAL or CLOUD
        FaceVerify faceVerify = FaceVerify.createInstance(RunMode);
        if (faceVerify == null) {
            System.out.println("FaceVerify.createInstance error");
            return;
        }
        FaceDetect faceDetect = FaceDetect.createInstance(RunMode);
        if (faceDetect == null) {
            System.out.println("FaceDetect.createInstance error");
            return;
        }

        byte[] imageData1 = Utils.loadFile(Utils.PICTURE_ROOT + "liudehua_feature1.jpg");
        Image image1 = new Image();
        image1.data = imageData1;
        image1.format = ImageFormat.ImageFormat_UNKNOWN;

        byte[] imageData2 = Utils.loadFile(Utils.PICTURE_ROOT + "liudehua_feature2.jpg");
        Image image2 = new Image();
        image2.data = imageData2;
        image2.format = ImageFormat.ImageFormat_UNKNOWN;

        Face[] faces1 = faceDetect.detectPicture(image1);
        Face[] faces2 = faceDetect.detectPicture(image2);

        //score >=70
        VerifyResult verifyResult[] = faceVerify.verifyPicture(image1, faces1[0], image2, faces2);
        if (verifyResult == null) {
            System.out.println("verifyPicture result number:0");
        } else {
            System.out.println("verifyPicture result number:" + verifyResult.length);
            for (int i = 0; i < verifyResult.length; i++) {
                System.out.println("verifyPicture result [" + i + "]:" + verifyResult[i]);
            }
        }

        FaceVerify.deleteInstance(faceVerify);
        FaceDetect.deleteInstance(faceDetect);
        System.out.println("verifyPicture end\n\n======================");
    }
}
