import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    title: 'Navigation Basics',
    home: FirstRoute(),
  ));
}

class FirstRoute extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Scaffold(
      appBar: AppBar(
        
        title: Center(
          child: Text(
            'sadat',
          ),
        ),
      ),
      bottomNavigationBar: BottomNavigationBar(
        type: BottomNavigationBarType.fixed,
        unselectedItemColor: Colors.white,
        fixedColor: Colors.white,
        backgroundColor: Colors.grey[700],
        items: const <BottomNavigationBarItem>[
          BottomNavigationBarItem(
            icon: Icon(Icons.star),
            title: Text('home'),

          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.subscriptions),
            title: Text('beğendiklerim'),
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.settings),
            title: Text('Ayarlar'),
          ),
        ],
      ),
    );
  }
}
