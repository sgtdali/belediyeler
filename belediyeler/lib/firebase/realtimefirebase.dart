import 'package:firebase_database/firebase_database.dart';

class RealTimeDatabase {
  static var aaa;
  static var bbb;
  static List tarih = [];
  static List postList = [];

  dataformfirebase() async {
    tarih = [];
    DatabaseReference postref2 =
        await FirebaseDatabase.instance.reference().child('haberlertarihleri');
    await postref2.once().then((DataSnapshot snap) {
      var DATA = snap.value.keys;
      var DATA2 = snap.value;
      for (var dat in DATA) {
        tarih.add(DATA2[dat]);
      }
      tarih.sort((a, b) {
        var adate = a['tarih']; //before -> var adate = a.expiry;
        var bdate = b['tarih']; //var bdate = b.expiry;
        return bdate.compareTo(adate);
      });
    });
  }

}
