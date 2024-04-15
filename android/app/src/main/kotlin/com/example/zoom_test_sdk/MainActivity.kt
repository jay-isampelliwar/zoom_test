package com.example.zoom_test_sdk

import android.content.Context
import android.util.Log
import android.widget.Toast
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import us.zoom.sdk.JoinMeetingOptions
import us.zoom.sdk.JoinMeetingParams
import us.zoom.sdk.MeetingParameter
import us.zoom.sdk.MeetingServiceListener
import us.zoom.sdk.MeetingStatus
import us.zoom.sdk.ZoomError
import us.zoom.sdk.ZoomSDK
import us.zoom.sdk.ZoomSDKInitParams
import us.zoom.sdk.ZoomSDKInitializeListener

const val JWT_TOKEN ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzZGtLZXkiOiJJMnZRNUUxVGdTR2NnaEtqNGxsRlEiLCJhcHBLZXkiOiJJMnZRNUUxVGdTR2NnaEtqNGxsRlEiLCJpYXQiOjE3MTMwMDUzNTYsImV4cCI6MTcxNTU5NzM1NiwidG9rZW5FeHAiOjE3MTU1OTczNTZ9.A_MAB_k6aLh9842OOuhbf06A33vPDhD7_SRZEJCcj7A"
const val ZOOM_ACCESS_TOKEN = "ZOOM-ZAK-TOKEN"
//You can get this from iOS AppDelegate methods. I have added couple of methods to generate ZAK token there. You can make use of it.
const val WEB_DOMAIN = "zoom.us"
var MEETINGID: String? = null
var PASSCODE: String? = null
private const val DISPLAY_NAME = "USERNAME"
private val CHANNEL = "ZoomChannel"
class MainActivity: FlutterActivity() {

//    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
//        super.configureFlutterEngine(flutterEngine)
//
//        val channel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger , "zoom_test_sdk");
//
//        channel.setMethodCallHandler { call, result ->
//
//            if(call.method == "showToast"){
//                Toast.makeText(this, "Hello World" , Toast.LENGTH_LONG).show();
//            }
//
//            if(call.method == "initializeSDK") {
//                try {
//                    initializeSdk(this@MainActivity);
//                    result.success(true)
//                } catch (e: Exception) {
//                    result.error(e.localizedMessage , e.message , e.stackTrace.toString());
//                }
//            }
//            else if(call.method == "joinMeeting"){
//                MEETINGID = call.argument<String>("meetingID");
//                PASSCODE = call.argument<String>("meetingPasscode");
//                showToastMessage("$MEETINGID $PASSCODE")
//                joinMeeting(this@MainActivity)
//            }
//
//        }
//    }
//
//    private fun initializeSdk(mainActivity: MainActivity) {
//        try {
//            val sdk = ZoomSDK.getInstance()
//            val params = ZoomSDKInitParams()
//            params.jwtToken = JWT_TOKEN
//            params.domain = WEB_DOMAIN
//            params.enableLog = true
//            val listener: ZoomSDKInitializeListener = object : ZoomSDKInitializeListener {
//                override fun onZoomSDKInitializeResult(errorCode: Int, internalErrorCode: Int) {
//                    if (errorCode == ZoomError.ZOOM_ERROR_SUCCESS) {
//                        showToastMessage("Zoom SDK initialization Successfully")
//                    } else {
//                        showToastMessage("Zoom SDK initialization failed with error code: $errorCode")
//                    }
//                }
//
//                override fun onZoomAuthIdentityExpired() {
//                }
//            }
//            sdk.initialize(mainActivity, listener, params)
//        } catch (e: Exception) {
//            // Log the exception for debugging purposes
//            Log.e("ZoomSDK", "Failed to initialize Zoom SDK", e)
//            showToastMessage("Failed to initialize Zoom SDK: ${e.message}")
//        }
//    }
//
//    private fun showToastMessage( message : String) {
//        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
//    }
//
//    private fun joinMeeting(context: Context) {
//
//        try {
//            val meetingService = ZoomSDK.getInstance().meetingService
//
//            if (!ZoomSDK.getInstance().isInitialized){
//                showToastMessage("Not INIT")
//            }
//            else {
//                showToastMessage("It's INIT")
//            }
//
//            val options = JoinMeetingOptions()
//            val params = JoinMeetingParams()
//            params.displayName = DISPLAY_NAME
//            params.meetingNo = MEETINGID
//            params.password = PASSCODE
//            meetingService.joinMeetingWithParams(context, params, options)
//            showToastMessage("joinMeeting")
//        }
//        catch (e: Exception) {
//            Log.e("ZoomSDK", "joinMeeting: ${e.toString()}", )
//        }
//
////        val params = JoinMeetingParams()
////        params.meetingNo = MEETINGID
////        params.displayName = DISPLAY_NAME
////        val options = JoinMeetingOptions()
////        ZoomSDK.getInstance().meetingService.joinMeetingWithParams(this, params, options)
//    }
//
//    override fun onMeetingStatusChanged(p0: MeetingStatus?, p1: Int, p2: Int) {
//        TODO("Not yet implemented")
//    }
//
//    override fun onMeetingParameterNotification(p0: MeetingParameter?) {
//        TODO("Not yet implemented")
//    }
//
//    override fun onZoomSDKInitializeResult(p0: Int, p1: Int) {
//        TODO("Not yet implemented")
//    }
//
//    private fun registerMeetingServiceListener() {
//        val zoomSDK = ZoomSDK.getInstance()
//        val meetingService = zoomSDK.meetingService
//        meetingService?.addListener(this)
//    }
//
//    override fun onZoomAuthIdentityExpired() {
//    }

//    private fun startMeeting() {
//        val meetingService: MeetingService = sdk.getMeetingService()
//        val opts = StartMeetingOptions()
//        opts.no_invite = true
//        val params = StartMeetingParamsWithoutLogin()
//        params.zoomAccessToken = ZOOM_ACCESS_TOKEN
//        params.meetingNo = MEETINGID
//        params.displayName = DISPLAY_NAME
//        meetingService.startMeetingWithParams(this, params, opts)
//    }
}
