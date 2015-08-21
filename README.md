# Swagpad

Description
--------------
* IST 297J: Intermediate and Object-Oriented App Development semester project
* Notepad application with CRUD functionality
* GUI written from scratch with Java's Swing library
* JTable used to display saved notes
* Data is persisted with serialization

Installation
--------------
````
git clone https://github.com/shwheelz/swagpad
````
Run SwagPad.java 

Login
--------------
<img src="http://i.imgur.com/ujSaPGh.png" alt="Login UI" >

* You can Login as one of the test users or add another user to UserList.java
* If you add to UserList.java, be sure to assign the user a corresponding password in PasswordList.java
* Valid users are Test User1, Test User2, Test User3... Test User10
* Valid passwords are Test Password1, Test Password2, Test Password3... Test Password10


Note Table
--------------
<img src="http://i.imgur.com/eg6aGOr.png" alt="NoteTableUI" >

* Notes are displayed in a JTable with CRUD functionality
* Data is saved an persisted with serialization, so you will see changes even after you exit the app


Note Editing
--------------
<img src="http://i.imgur.com/7ZcLUL9.png" alt="NoteUI" >

* Notes have an id, title, description, and body
* All except the id can be edited
* When you save your note, it is serialized and will be revived between runs

To Do
--------------
* Have JTable automatically update the model from NoteTableUI so users don't have to click into a note to edit title and description
* Fix users sharing the same NoteList
