import 'package:belediyeler/HomePage/home.dart';
import 'package:belediyeler/HomePage/news.dart';
import 'package:belediyeler/firebase/firebase.dart';
import 'package:belediyeler/firebase/realtimefirebase.dart';
import 'package:belediyeler/firebase/userindinfo.dart';
import 'package:belediyeler/firebase/userinfo.dart';
import 'package:belediyeler/shared/spinner.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class homepage extends StatefulWidget {
  @override
  _homepageState createState() => _homepageState();
}

class _homepageState extends State<homepage> {
  RealTimeDatabase realTimeDatabase = new RealTimeDatabase();
  bool loading = true;

  void initState() {
    super.initState();

    asyinit().whenComplete(() {
      setState(() {
        loading = false;
      });
      print("success");
    }).catchError((error, stackTrace) {
      print("outer: $error");
    });
  }

  Future<void> asyinit() async {
    await realTimeDatabase.dataformfirebase();
  }

  int _selectedIndex = 0;
  String _title = 'Ana Akış';

  static const TextStyle optionStyle =
      TextStyle(fontSize: 30, fontWeight: FontWeight.bold);
  final List<Widget> _widgetoptions = [
    News(),

    userList(),
  ];


  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
      switch (index) {
        case 0:
          {
            _title = 'Ana Akış';
          }
          break;
        case 1:
          {
            _title = 'Takip Ettiklerim';
          }
          break;
        case 2:
          {
            _title = 'Profil';
          }
          break;
      }
      if (_title == null) {
        _title = 'Ana Akış';
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return loading
        ? spinner()
        : StreamProvider<List<Userind>>.value(
      value: DatabaseService().Users,
      child: Scaffold(

        body: new Stack(
          children: <Widget>[
            new Offstage(
              offstage: _selectedIndex != 0,
              child: new TickerMode(
                enabled: _selectedIndex == 0,
                child: new MaterialApp(home: new News()),
              ),
            ),
            new Offstage(
              offstage: _selectedIndex != 1,
              child: new TickerMode(
                enabled: _selectedIndex == 1,
                child: new MaterialApp(home: new HomePage()),
              ),
            ),
            new Offstage(
              offstage: _selectedIndex != 2,
              child: new TickerMode(
                enabled: _selectedIndex == 2,
                child: new MaterialApp(home: new userList()),
              ),
            ),
          ],
        ),
        bottomNavigationBar: BottomNavigationBar(
          items: const <BottomNavigationBarItem>[
            BottomNavigationBarItem(
              icon: Icon(Icons.home),
              title: Text('Ana Akış'),
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.subscriptions),
              title: Text('Takip Ettiklerim'),
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.settings),
              title: Text('Profil'),
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
