import 'package:belediyeler/HomePage/news1.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';


class NewsDetail extends StatelessWidget {

  String URL;
  String haberbaslik;
  String belediye;
  String tarih;

  String index;

  NewsDetail(this.URL, this.haberbaslik, this.belediye, this.tarih, this.index);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(haberbaslik),
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: <Widget>[

          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: <Widget>[
              Text(belediye),
              Text(tarih),
            ],
          ),
          SizedBox(
            height: 10,
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Image.network(
                URL,
                fit: BoxFit.cover,
              ),
            ],
          ),
          SizedBox(
            height: 10,
          ),
          Text(
            haberbaslik,
            textAlign: TextAlign.center,
            style: TextStyle(fontWeight: FontWeight.bold),
          ),
          SizedBox(
            height: 10,
          ),
          NewsDetail1(index),
        ],
      ),
    );
  }
}


/*Widget build(BuildContext context) {

  return Scaffold(
    appBar: AppBar(
      title: Text("deneme"),
    ),
    body:  SingleChildScrollView(
      padding: EdgeInsets.all(20),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: <Widget>[
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: <Widget>[
              Text('İBB'),
              Text('26.06.2020'),
            ],
          ),
          SizedBox(
            height: 10,
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Image.network(
                URL,
                fit: BoxFit.cover,
              ),
            ],
          ),
          SizedBox(
            height: 10,
          ),
          Text(
            haberbaslik,
            textAlign: TextAlign.center,
            style: TextStyle(fontWeight: FontWeight.bold),
          ),
          Text(
            habericerik1,
          ),
          Text(habericerik2),
        ],
      ),
    ),
  );
}
}*/




