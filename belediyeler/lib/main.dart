import 'package:belediyeler/chooser.dart';
import 'package:belediyeler/firebase/authentication.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'firebase/users.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  //deneme
  Widget build(BuildContext context) {
    return StreamProvider<Users>.value(
      value: AuthService().user,
      child: MaterialApp(
        home: Chooser(),
      ),
    );
  }
/* TODO : 1)formlar düzeltilecek Batu
   2) firebase ortak gmaile taşınacak Tayfun
   3) bütün arayüzler düzeltilecek
   4) phyton ile haber içerikleri alınacak Tayfun
   5) navigaston ile haber içeriğine gidilecek Batu
   6) anasayfaki card widget düzenleceke














   */
}
