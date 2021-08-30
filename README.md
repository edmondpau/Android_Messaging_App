# Android Messaging App

This Android App is a free social and messaging app inspired by Whatsapp and Messenger. The real-time 1-to-1 app is built using Java and Firebase. 

## Features

* Firebase: 
    - Authentication (Email, Facebook, Google, Phone) 
    - Cloud Firestore Cloud 
    - Messaging 
    - Functions 
    - Remote 
    - Config 
    - Storage
* Create user profile (Username).
* Search users by Username.
* Send text, graphic, audio messages.
* Take a picture from camera or gallery.
* Record/play audio.
* Display graphics in full screen view, zoom in/out, drag and rotate.
* Check user online status.
* Check message read/delivery status.
* Get notifications about new messages.

## Setup

* Android Studio
    1. Clone or download repository as a zip file.
    2. Open project in Android Studio.
    3. For the complete installation guide, please check (https://developer.android.com/studio/install)

* Firebase
    1. Create Firebase Project (https://console.firebase.google.com/).
    2. Import the file google-service.json into your project.
    3. Connect to firebase console authentication and database from your IDE.
    4. Make sure you have all the dependencies setup. The most important one is the com.google.firebase:firebase-auth. It has to be the latest version.
    5. Change  the value of "allow read, write:" from "if request.auth != null" to "if true.
    6. For the complete guide, please check (https://firebase.google.com/docs/auth/android/start).

## Tech Stack Used

* [Java](https://www.java.com/)
* [MVVM](https://developer.android.com/jetpack/docs/guide)
* [Lifecycles](https://developer.android.com/topic/libraries/architecture/lifecycle) - Create a UI that automatically responds to lifecycle events.
* [Paging](https://developer.android.com/topic/libraries/architecture/paging/) - Load and display small chunks of data at a time.
* [Glide](https://github.com/bumptech/glide) - Load and cache images by URL.
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Store UI-related data that isn't destroyed on app rotations. Easily schedule asynchronous tasks.
* [Data Binding](https://developer.android.com/topic/libraries/data-binding/) - Declaratively bind observable data to UI elements.
* [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Compile-time framework for dependency injection.
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Build data objects that notify views when the underlying database changes.
* [Test](https://developer.android.com/training/testing/) - An Android testing framework for unit and runtime UI tests.
* [Room](https://developer.android.com/topic/libraries/architecture/room) - Access your app's SQLite database with in-app objects and compile-time checks.
* [WorkManager](https://developer.android.com/topic/libraries/architecture/workmanager) - Schedule deferrable, asynchronous tasks even if the app exits or device restarts.
* [Dagger 2](https://github.com/google/dagger) - Compile-time framework for dependency injection.
* [Navigation](https://developer.android.com/guide/navigation/) - Handle everything needed for in-app navigation.
* [Retrofit 2](https://github.com/square/retrofit) - Handle REST api communication.
* [Firebase](https://firebase.google.com/docs) - Tools to develop high-quality apps.
  - [Authentication](https://firebase.google.com/docs) - Allows an app to securely save user data in the cloud.
  - [Cloud Firestore](https://firebase.google.com/docs/firestore) - Flexible, scalable NoSQL cloud database to store and sync data.
  - [Cloud Functions](https://firebase.google.com/docs/functions) - Automatically run backend code in response to events triggered by Firebase 
  - [Cloud Messaging](https://firebase.google.com/docs/cloud-messaging) - Notify a client app.
  - [Cloud Storage](https://firebase.google.com/docs/storage) - Store and serve user-generated content.
  - [Remote Config](https://firebase.google.com/docs/remote-config) - Change the settings of app without requiring users to download an app update.


[reference]

https://firebase.google.com/docs/android/setup

https://developer.android.com/studio/install