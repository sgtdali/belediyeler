import 'package:belediyeler/HomePage/mainpage.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'auth/register.dart';
import 'firebase/users.dart';

class Chooser extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final user = Provider.of<User>(context);

    if (user == null) {
      return Register();
    } else {
      return homepage();
    }
  }
}
