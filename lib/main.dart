import 'dart:developer';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:permission_handler/permission_handler.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Demo',
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  final channel = const MethodChannel("zoom_test_sdk");

  TextEditingController meetingIdController = TextEditingController(
      text: "977 3456 8809"); // replace with your meeting id
  TextEditingController meetingPasscodeController = TextEditingController(
      text: "5NcVVu"); // replace with your meeting passcode

  @override
  void initState() {
    super.initState();
    requestPermissions();
    initializeSDK();
  }

  Future<void> requestPermissions() async {
    Map<Permission, PermissionStatus> statuses = await [
      Permission.camera,
      Permission.microphone,
      Permission.storage,
      Permission.location,
      Permission.notification,
    ].request();
    print(statuses);
  }

  @override
  void dispose() {
    meetingIdController.dispose();
    meetingPasscodeController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              TextField(
                controller: meetingIdController,
                decoration: const InputDecoration(
                  hintText: "Meeting ID",
                ),
              ),
              const SizedBox(
                height: 20,
              ),
              TextField(
                  controller: meetingPasscodeController,
                  decoration: const InputDecoration(
                    hintText: "Meeting Passcode",
                  )),
              const SizedBox(
                height: 20,
              ),
              ElevatedButton(
                  onPressed: () {
                    String id = meetingIdController.text.trim();
                    String passcode = meetingPasscodeController.text.trim();

                    if (id.isEmpty || passcode.isEmpty) return;

                    joinMeeting(id, passcode);
                    // meetingIdController.clear();
                    // meetingPasscodeController.clear();
                  },
                  child: const Text("Join Meeting")),
            ],
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {},
        child: const Icon(Icons.arrow_forward),
      ),
    );
  }

  void joinMeeting(String id, String passcode) async {
    try {
      await channel.invokeMethod(
        'joinMeeting',
        {
          "meetingID": id,
          "meetingPasscode": passcode,
        },
      );
    } on PlatformException catch (e) {
      log(e.toString());
    } catch (e) {
      log(e.toString());
    }
  }

  Future<void> initializeSDK() async {
    try {
      var res = await channel.invokeMethod("initializeSDK");
      bool status = res as bool;
      if (status) {
        log("SUCCESS");
      } else {
        log("FAILED");
      }
    } on PlatformException catch (e) {
      log(e.toString());
    } catch (e) {
      log(e.toString());
    }
  }
}
