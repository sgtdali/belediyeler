import 'package:flutter/material.dart';
import 'package:flutter_spinkit/flutter_spinkit.dart';

class spinner extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.red,
      child: SpinKitChasingDots(
        color: Colors.black,
        size: 50,
      ),
    );
  }
}
