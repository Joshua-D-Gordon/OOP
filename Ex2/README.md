# **Project**
## ***By Asaf Shmaryahu & Johsua Gordon***
### **Table Of Content's**
|Number| Content | Description |
|---| ----------------- | ------------------------------ |
|0| Overview | About our Project |
|1| Observer design pattern | About our desision and why we chose this design pattern |
|2| Class's implimented | About the Class's we implimented to achive the design pattern |
|2.1| Group Admin | About our implimentaion of our Groupadmin class |
|2.2| ConcreteMember | About our implimentaion of our Concretemember class |
|3| Memory and Algorithim's efficiency  | About how we maximized efficiency and minimized memory while implementing our code |
|4| Catching error's & tests | About how we caught potential error's implementing our code |
|5| Our findings  | About our findings while implementing our code |
|6| **Try it yoursef!**  | About how you can use our code |

0. **About our project** - 
Our project implements a group admin who can register and unregister Concretememberes. a group admin and a Concretemember have a (class) undoablestringbuilder. this class lets the group admin do vairious methods on its seqence such as appending a string, replaceing a string, reversing a string, deleting a sub string from its current seqence , undoing its last method and more. Once a group admin has used a method on its seqence all memebrs undoAbleStringBuilder who are registed to this groupadmin will be updated accordingly to the group admins version of its undoAbleStringBuilder.

1. **Observer design pattern** - 
Our projet implements the design patterns of observer into our Undoable String builder algorithem that we created in our prevous task. We implemented this design pattern as it would be irratinal for Concretemembers to continuasly ask via a reqest if groupadmin has updated its undoAbleStringbuilder in order for them to recive an updated version of the groupadmins. Rather let the groupadmin once it has updated its undoAbleStringbuilder update/Notify its Concrete memebrs wich are registered.

2. **by doing so we created a 2 new Class's:**

2.1 **GroupAdmin** - a class that implements the sender(subject) interface,the class has 2 constructors (the empty and the one that gets an array list of concrete members) and impliments the follwing methods:

 ***Register***: puts a new concrete member in the array list of the group admin and updates the UndoableStringBuilder of the new member to the last updated undoAbleStringbuilder of the admin.

 ***Unregister***: remove the concrete member that the group  admin wants to unregister from the array list.

 ***insert***: this method insert a string into the usb  (UndouableStringBuilder) of the group admin with a start offset location and then updates all of the conncrete members in the array list of the group admin.

 ***append***: appends a new String to the usb (UndoableStringBuilder) and then updates all of the members in admins arraylist of registered Concretemembers. 

 ***delete***: remove all the characters in the usb from the index start to the index ens-1 and then updates all of the concrete members in the admins array list.

 ***undo***: this method dose a undo to the last usb from the group admin and then updates all of the conncrete memmbers in the array list of the group admin.


2.2 **ConcreteMember** - a class that implements the Member interface, this class has the empty constructor for the concrete member and initilizes its UndoableStringbuilder to NULL for saving memory,and impliments the follwoing methods:
 
 ***getUsb***: this method returns the usb(UndoableStringBuilder) of the Concrete member.

 ***update***: this method is a method from the interface that updates the usb to the usb the admin put.
 
 3. **Memory and Algorithim's efficiency** - We added a shallow copy constructor to undoableStringbuilder. by doing so we were able to point each Concretememebr's undoAbleStringBuilder to the admins. this saves a lot of memory as no need for a new full copy for each new memmber. we also initilized Each new Concrete memebrs UndoAbleStringBuilder to NULL; to save memeory untill its added to a group admins array list and only then will it point to the GroupAdmin's UndoableStringbuilder.
 we Used getters for a ConcreteMembers UndoableStringbuilder and created a new memebr in the register function of groupAdmin, hence once a memebr is removed he is deleted.
 
 4. **Catching error's & test's** - We catch the error of unregestering a non existing memeber as the array list would return -1. we tested multiple admin methods and checked that the Memebrs where updated accordingly. we caught all Undoablestringbuilder potential errors with try's and catch's in the last exersie.
 
 5. **Our findings** - via logging the JVM INFO we found that as expected the footprint size of admin increases when adding memebers (not by a lot as the memebrs undoablestringbuilder is Null), once updated the size increases as the admin holds an array list of Concretemembers that now point to its UndoableStringBuilder.
 We also found by appeneding to the admins Undoable string builder its footprint increases as well due to the fact that it holds a undoableStringbuilder that holds a now updated appened seqence contaning data rather than an emepty string.


6. **Try it yourself!** - downloading and running: download the zip from the github you currently on and open it in a JVM and run the tests class to see how the project runs,how much memory size is alocated at each stage , what liberies we used, the time you run the project (date,the current time) will be printed as well as the values with loggers.

OR

1. Open your terminal and navigate to the directory where you want to clone the project.
2. Clone the repository:
```
git clone https://github.com/Joshua-D-Gordon/Matala1-OOP.git
```
3. Navigate to the test in the project directory:
```
cd Matala1-OOP/OOP.Assignment1/target/test-classes/
```
5. run the test file:
```
java -jar junit-platform-console-standalone-5.9.0.jar --class-path test-classes --select-class com.baeldung.commandline.Tests
```



