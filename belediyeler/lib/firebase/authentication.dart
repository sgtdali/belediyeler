import 'dart:async';

import 'package:belediyeler/firebase/firebase.dart';
import 'package:belediyeler/firebase/users.dart';
import 'package:firebase_auth/firebase_auth.dart';

class AuthService {
  StreamController streamController = new StreamController<String>();
  static var asdfg;
  bool loading;
  final FirebaseAuth _auth = FirebaseAuth.instance;

  // create user object
  Users _userFromFirebaseUser(FirebaseUser user) {
    return user != null ? Users(uid: user.uid) : null;
  }

  // Auth change
  Stream<Users> get user {
    return _auth.onAuthStateChanged.map(_userFromFirebaseUser);
  }

  //Register
  Future registerWithEmailandPassword(String email, String password,
      String name, String surname, String age) async {
    try {
      AuthResult result = await _auth.createUserWithEmailAndPassword(
          email: email, password: password);

      FirebaseUser user = result.user;
      await DatabaseService(uid: user.uid).updateUserData(name, surname, age);
      return _userFromFirebaseUser(user);
    } catch (e) {
      print(e.toString());
      return null;
    }
  }

  //Login
  Future loginWithEmailandPassword(String email, String password) async {
    try {
      AuthResult result = await _auth.signInWithEmailAndPassword(
          email: email, password: password);
      FirebaseUser user = result.user;

      return _userFromFirebaseUser(user);
    } catch (e) {
      print(e.toString());
      return null;
    }
  }

//Logout
  Future signOut() async {
    try {
      return _auth.signOut();
    } catch (e) {
      print(e.toString());
      return null;
    }
  }
}
