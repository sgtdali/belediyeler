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

  DocumentSnapshot usersfollow(DocumentSnapshot snapshot) {
    return snapshot;
  }

  Stream<DocumentSnapshot> get follow {
    return userCollection.document(uid).snapshots().map(usersfollow);
  }

  Future updateUserFollow(String belediye) async {
    try {
      return await userCollection.document(uid).updateData({
        'follow': FieldValue.arrayUnion([belediye])
        //'follow': FieldValue.arrayRemove(['ABB'])
      });
    } catch (e) {
      print(e.toString());
    }
  }

  Future deleteUserFollow(String belediye) async {
    try {
      return await userCollection.document(uid).updateData({
        //'follow': FieldValue.arrayUnion([belediye])
        'follow': FieldValue.arrayRemove([belediye])
      });
    } catch (e) {
      print(e.toString());
    }
  }
}
