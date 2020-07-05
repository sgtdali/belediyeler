import 'package:belediyeler/HomePage/mainpage.dart';
import 'package:belediyeler/auth/loginregister.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'firebase/users.dart';

class Chooser extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final user = Provider.of<Users>(context);

    if (user == null) {
      return LoginRegister();
    } else {
      return homepage();
    }
  }
}
