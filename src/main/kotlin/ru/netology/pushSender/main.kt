package ru.netology.pushSender

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val remoteMessage = Message.builder()
        .putData("action", "TEXT")
        .putData("content", """{
       "authorName":"Vasya",
       "title":"Новое сообщение",
       "minText":"Нажмите чтобы отобразить",
       "contentText": "Сообщение должно быть длинное, соответственно шторка должна увеличиваться в размерах для отображения всего текста"
          }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(remoteMessage)



    val message = Message.builder()
        .putData("action", "LIK")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)
}