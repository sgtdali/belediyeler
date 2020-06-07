import 'package:belediyeler/screens/auth/register.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';

class Login extends StatefulWidget {
  @override
  _LoginState createState() => _LoginState();
}

class _LoginState extends State<Login> {
  String _email, _password;
  final GlobalKey<FormState> _formkey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Giriş'),
      ),
      body: Container(
        margin: const EdgeInsets.all(10),
        child: Form(
          key: _formkey,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              TextFormField(
                validator: (input) {
                  if (input.isEmpty) {
                    return 'Email bölümü boş bırakılamaz.';
                  }
                },
                onSaved: (input) => _email = input,
                decoration: InputDecoration(labelText: 'Email'),
              ),
              TextFormField(
                validator: (input) {
                  if (input.length < 6) {
                    return 'Şifre bölümü boş bırakılamaz.';
                  }
                },
                onSaved: (input) => _password = input,
                decoration: InputDecoration(labelText: 'Şifre'),
                obscureText: true,
              ),
              RaisedButton(
                onPressed: signIn,
                child: Text('GİRİŞ'),
              )
            ],
          ),
        ),
      ),
    );
  }

  Future<void> signIn() async {
    final formState = _formkey.currentState;
    if (formState.validate()) {
      formState.save();
      try {
        await FirebaseAuth.instance
            .signInWithEmailAndPassword(email: _email, password: _password);
        Navigator.push(
            context, MaterialPageRoute(builder: (context) => Register()));
      } catch (e) {
        print(e);
      }
    }
  }
}
