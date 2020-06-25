import 'package:belediyeler/HomePage/news.dart';
import 'package:belediyeler/firebase/authentication.dart';
import 'package:belediyeler/firebase/firebase.dart';
import 'package:belediyeler/firebase/userindinfo.dart';
import 'package:belediyeler/firebase/userinfo.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class homepage extends StatefulWidget {
  @override
  _homepageState createState() => _homepageState();
}

class _homepageState extends State<homepage> {
  int _selectedIndex = 0;
  static AuthService _authService = AuthService();
  static const TextStyle optionStyle =
  TextStyle(fontSize: 30, fontWeight: FontWeight.bold);
  final List<Widget> _widgetoptions = [
    Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        RaisedButton(
          onPressed: () async {
            dynamic result = await _authService.signOut();
          },
          child: Text('Çıkış'),
        ),
        Text(
          'Home',
          style: optionStyle,
        ),
      ],
    ),
    News(),
    userList(),
  ];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return StreamProvider<List<Userind>>.value(
      value: DatabaseService().Users,
      child: Scaffold(
        appBar: AppBar(
          title: Text('home'),
        ),
        body: Center(
          child: _widgetoptions.elementAt(_selectedIndex),
        ),
        bottomNavigationBar: BottomNavigationBar(
          items: const <BottomNavigationBarItem>[
            BottomNavigationBarItem(
              icon: Icon(Icons.home),
              title: Text('home'),
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.subscriptions),
              title: Text('like'),
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.settings),
              title: Text('settings'),
            ),
          ],
          currentIndex: _selectedIndex,
          selectedItemColor: Colors.amber,
          onTap: _onItemTapped,
        ),
      ),
    );
  }
}
