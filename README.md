# MTTPSProject
  <hr>
  <h3><b>Projekt za kolegij MTTPS <b></h3>

  Testiranje Android aplikacije koristeći Selenium, Appium, TestNG i integracija s Jenkins CI poslužiteljem   <br><hr>
  
Popis potrebnih alata:

Android Studio (http://developer.android.com/sdk/index.html)<br>
JDK(Java Development Kit) (8+) (https://www.oracle.com/java/technologies/downloads/)<br>
Intellij IDEA / Eclipse (https://www.eclipse.org/downloads/)<br>
TestNG<br>
Selenium-Java<br>
Node.js<br>
Appium 1.18.3 (https://github.com/appium/appium-desktop/releases/tag/v1.18.3)<br>
Android aplikacija (https://github.com/Kvesss/Breeze)<br>
Jenkins (https://www.jenkins.io/download/) - Generic Java Package (.war)<br>
Maven (https://dlcdn.apache.org/maven/maven-3/3.8.4/binaries/apache-maven-3.8.4-bin.zip)<br>
  <hr>
  <br>
  Emulator
  
  1) Search -> Uređivanje varijabli okruženja sustava -> Varijable okruženja
   Pod korisničke varijable dodati:<br> ANDROID_HOME = C:\Users\<username>\AppData\Local\Android\Sdk <br>
   Pod sistemske varijable dodati:<br> C:\Users\<username>\AppData\Local\Android\Sdk\tools <br> C:\Users\<username>\AppData\Local\Android\Sdk\emulator

       ![image](https://user-images.githubusercontent.com/60116655/153585906-cbf8caa0-2d77-44c2-a6f0-a114bf2eb523.png) <br><br>
  
  2) Pokrenuti Daemon proces u: <br>
  C:\Users\<username>\AppData\Local\Android\Sdk\platform-tools
  >   adb devices

  3) Pokrenuti emulator iz Android Studia - Tools -> AVD Manager -> Run
  
  <hr>
  <br>
  Appium 
  <br><br>
  Appium je slobodno distribuirani okvir za testiranje korisničkog sučelja otvorenog koda za
mobilne aplikacije. Appium omogućuje provjeru autentičnih, hibridnih i web aplikacija i podržava test
automatizacije na fizičkim uređajima, kao i emulator ili simulator.
  
  
  Za pokretanje Appiuma potrebno je imati instaliran Node.js
  
  1) Pokrenuti preuzetu datoteku Appium<br>
  
  2) Podesiti konfiguraciju <br>
  
        ![image](https://user-images.githubusercontent.com/60116655/153586988-d36116ff-5cf1-4b7a-a81b-33228c6ec7ec.png)
  
  3) Start Server
  
  4) File -> New Session Window
  
  <br>
      
      Namjestiti Desired Capabilities i pokrenuti sesiju. (Pronaći putanju do app-debug.apk datoteke od preuzete aplikacije)
      Ime emulatora može se razlikovati. Provjeriti se može naredbom:
      >adb devices na C:\Users\<username>\AppData\Local\Android\Sdk\platform-tools
      Verzija uređaja dostupna je u postavkama uređaja.
   
      {
        "app": "<path>\\Breeze\\app\\build\\outputs\\apk\\debug\\app-debug.apk",
        "VERSION": "11",
        "deviceName": "emulator-5554",
        "platformName": "ANDROID",
        "appActivity": "com.example.breeze.LoginActivity",
        "appPackage": "com.example.breeze"
      }
  
  <br>
  <hr>
  <br>
  Maven
  <br><br>
  Maven je alat za upravljanje i automatizaciju Java projekata. Radi na Project Object Model (POM) principu. Omogućava jednostavno upravljanje ovisnostima projekta.
  
  <br>
  1) Extract preuzetu .zip datoteku u C:\Program Files
  <br>
  2) Ponovno otvoriti varijable okruženja te dodati:<br>
  
  Korisničke varijable: <br> M2_HOME = C:\Program Files\apache-maven-3.8.4-bin\apache-maven-3.8.4 <br>MAVEN_HOME = C:\Program Files\apache-maven-3.8.4-bin\apache-maven-3.8.4
  <br>
  Sistemske varijable: <br>C:\Program Files\Java\jdk-11.0.11\bin <br> C:\Program Files\apache-maven-3.8.4-bin\apache-maven-3.8.4\bin <br>
  
  Detaljnije upute na: https://www.youtube.com/watch?v=RfCWg5ay5B0
  <br><br>
  
  Pokretanje Maven projekta<br>
  
  1) Klonirati ili preuzeti Maven projekt zip sa https://github.com/Kvesss/MTTPSProject/tree/master <br>
  
  2) Pokrenuti Eclipse 
  
  3) Uvesti Maven projekt: File -> Import -> Maven -> Existing Maven Projects -> Browse (direktorij projekta)
  
  4) Pregledati Testne klase, pom.xml i testng.xml
  
        ![image](https://user-images.githubusercontent.com/60116655/153593243-9b9aebd6-57b1-4bae-b6b1-14a73e1a31f7.png)<br><br>
  
        ![image](https://user-images.githubusercontent.com/60116655/153608297-e59b53dc-8170-4e52-bdb3-144ecd1c2a54.png)

        ![image](https://user-images.githubusercontent.com/60116655/153593566-3b48a0f6-f9a2-4fca-865b-c81aa3875dc0.png)


  
  5) Desni klik na projekt -> Show in local terminal
  
        ![image](https://user-images.githubusercontent.com/60116655/153592429-8496608e-b6b4-4dd6-a24c-01b1c207034c.png)

  
  6) U terminal upisati -> <i>mvn test</i> (Emulator i Appium sesija pokrenuti) <br>
  
        ![image](https://user-images.githubusercontent.com/60116655/153592566-4e7cbbab-21bb-44d9-ba7d-c8c2a2db4ca5.png)
  
  
  7) Na terminalu će se prikazati rezultati testiranja. Otvoriti target/surefire-reports/index.html u Web pregledniku.
  
  ![image](https://user-images.githubusercontent.com/60116655/153608548-1ddf4d63-4f77-4a77-876c-56c63421267b.png)

  
  ![image](https://user-images.githubusercontent.com/60116655/153608100-23614d84-e890-4746-a9ed-ac05ff43a92d.png)

<br>
<hr>
<br>
  
  Jenkins 
  <br>
  Jenkins je automatizacijski alat otvorenog koda s ugrađenim alatima za kontinuiranu integraciju (CI). Developerima omogućuje lakši razvoj, gradnju i testiranje programskih sustava.
  
  <br>
  1) Pronaći lokaciju preuzete .war datoteke.
 
  2) u cmd-u upisati java -jar <path>\jenkins.war
  
  3) Generirat će se lozinka koju treba sačuvati 
  
  4) U web pregledniku otvoriti http://localhost:8080/
  
  5) Zalijepiti spremljenu lozinku
  
  6) Slijediti preporučene upute za instalaciju. Registracija korisnika.
  
  7) Odabrati Manage Jenkins -> Global Tool Configuration
  
  8) Postaviti JDK i Maven
  ![image](https://user-images.githubusercontent.com/60116655/153603415-4d7c488e-6a00-4097-959a-f29abd6cd3c7.png)
  <br>
  
  ![image](https://user-images.githubusercontent.com/60116655/153603955-949d5c57-0f75-4edc-a8c0-9afc84f7b562.png)
  <br>

  
  9) Odabrati New Item -> Freestyle Project. Dati ime projektu. <br>
  
  ![image](https://user-images.githubusercontent.com/60116655/153604221-240198c2-3560-4cb8-952d-31532ae909cd.png)
  
  ![image](https://user-images.githubusercontent.com/60116655/153604260-b1784e3b-8c0f-40bf-bf05-7eae773787d5.png)
  
  10) Otvoriti Advanced. u POM upisati putanju do POM.xml datoteke projekta.
  
  11) Spremiti konfiguraciju.
  
  12) U projektu kliknuti Build Now (Appium server mora biti pokrenut).
  
  ![image](https://user-images.githubusercontent.com/60116655/153605105-6703cf5b-a62c-43fc-be29-48767c57b005.png)
  
  ![image](https://user-images.githubusercontent.com/60116655/153605225-bcafb2f9-4f79-4f0c-ab3e-b06fba66fb3d.png)
  
  ![image](https://user-images.githubusercontent.com/60116655/153605505-d7838762-77e9-4414-a295-b1c43a642aae.png)

  
  





  
  

  
  
  
