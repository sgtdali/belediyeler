import 'package:belediyeler/firebase/authentication.dart';
import 'package:flutter/material.dart';

class Login extends StatefulWidget {
  @override
  _LoginState createState() => _LoginState();
}

class _LoginState extends State<Login> {
  String _email = '', _password = '';
  final GlobalKey<FormState> _formkey = GlobalKey<FormState>();
  final AuthService _authService = AuthService();

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
          child: Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                TextFormField(
                  validator: (input) {
                    if (input.isEmpty) {
                      return 'Email bölümü boş bırakılamaz.';
                    }
                  },
                  onChanged: (input) {
                    setState(() => _email = input);
                  },
                  decoration: InputDecoration(labelText: 'Email'),
                ),
                TextFormField(
                  validator: (input) {
                    if (input.length < 6) {
                      return 'Şifre bölümü boş bırakılamaz.';
                    }
                  },
                  onChanged: (input) {
                    setState(() => _password = input);
                  },
                  decoration: InputDecoration(labelText: 'Şifre'),
                  obscureText: true,
                ),
                RaisedButton(
                  onPressed: () async {
                    dynamic result = await _authService
                        .loginWithEmailandPassword(
                        _email, _password);
                    if (result == null) {
                      print('error');
                    }
                    else {
                      print('sig in');
                      print(result.uid);
                    }
                  },
                  child: Text('GİRİŞ'),
                )
              ],
            ),
          ),
        ),
      ),
    );
  }
}
