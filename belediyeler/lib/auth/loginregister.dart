import 'package:animated_text_kit/animated_text_kit.dart';
import 'package:belediyeler/auth/login.dart';
import 'package:belediyeler/auth/register.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';





class LoginRegister extends StatefulWidget {
  @override
  _LoginRegisterState createState() => _LoginRegisterState();
}

class _LoginRegisterState extends State<LoginRegister> {
  @override

  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.grey.shade200,
      body: Center(
        child: Container(
          padding: EdgeInsets.all(16),
          child: Column(
            mainAxisSize: MainAxisSize.max,
            crossAxisAlignment: CrossAxisAlignment.stretch,
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              SizedBox(
                height: 200,
                child: Center(
                  child: TypewriterAnimatedTextKit(
                    isRepeatingAnimation: false,
                    text: ["Belediye Haberleri"],
                    speed: Duration(milliseconds: 200),
                    textStyle: TextStyle(
                      fontSize: 35,
                    ),
                  ),
                ),
              ),
              SizedBox(
                height: 30,
              ),
              SizedBox(
                height: 48,
                child: RaisedButton(
                  shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.all(Radius.circular(24))),
                  color: Colors.red,
                  textColor: Colors.white,
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    mainAxisSize: MainAxisSize.max,
                    children: <Widget>[
                      Icon(Icons.assignment_ind, size: 36,),
                      Text('Giriş Yap', style: TextStyle(
                          fontSize: 20, fontWeight: FontWeight.bold),),
                      Opacity(opacity: 0, child: Icon(Icons.assignment_ind)),
                    ],
                  ),
                  onPressed: () {
                    Navigator
                        .of(context)
                        .push(new MaterialPageRoute(
                        builder: (BuildContext context) => Login()));
                  },
                ),
              ),
              SizedBox(
                height: 16,
              ),
              SizedBox(
                height: 48,
                child: RaisedButton(
                  shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.all(Radius.circular(24))),
                  color: Colors.blue,
                  textColor: Colors.white,
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    mainAxisSize: MainAxisSize.max,
                    children: <Widget>[
                      Icon(Icons.assignment_late, size: 36,),
                      Text('Kayıt Ol', style: TextStyle(
                          fontSize: 20, fontWeight: FontWeight.bold),),
                      Opacity(opacity: 0, child: Icon(Icons.assignment_ind)),
                    ],
                  ),
                  onPressed: () {
                    Navigator
                        .of(context)
                        .push(new MaterialPageRoute(
                        builder: (BuildContext context) => Register()));
                  },
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
