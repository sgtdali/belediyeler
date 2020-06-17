import 'package:belediyeler/firebase/userindinfo.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class DatabaseService {
  // collection reference
  final String uid;

  DatabaseService({this.uid});

  final CollectionReference userCollection =
  Firestore.instance.collection('Users');

  Future updateUserData(String name, String surname, String age) async {
    try {
      return await userCollection.document(uid).setData({
        'name': name,
        'surname': surname,
        'age': age,
        'uid': uid,
      });
    } catch (e) {
      print(e.toString());
    }
  }

  List<Userind> userfromsnapshot(QuerySnapshot snapshot) {
    return snapshot.documents.map((doc) {
      return Userind(
        name: doc.data['name'],
        surname: doc.data['surname'],
        age: doc.data['age'],
        uid: doc.data['uid'],
      );
    }).toList();
  }

  Stream<List<Userind>> get Users {
    return userCollection.snapshots().map(userfromsnapshot);
  }
}
