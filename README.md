# Eclipse Tutorial & Intro to Version Control

## Version Control Intro
Version control software is a type of software that lets us manage the evolution of files (for developers, this most often means source code) over time.  It lets us track the state of a software project, see what files have been changed, by who, when, and lets us revert to past versions should we so desire.  Git is the most commonly-used version control system because of its ease of use and powerful features.

Github, a web-based hosting service for Git repositories, is used to provide a public hosting for git repositories so that developers can share their source code and collaborate efficiently.  In addition to just hosting code, Github offers powerful collaboration features, including the ability to create _Issues_ to document bugs or requested enhancements, _Wikis_ to contain more information about how to use a project, and _Projects_ to track outstanding tasks.  Today, we'll just be looking at some of that.

If you haven't already done so, sign up for a [Github account](www.github.com).  This will be useful all weekend as you work on your projects, and allow you to share your source code with your teammates.  Then, fork a copy of this repository to your own Github account by clicking the "fork" account in the top-right of this page.  What does this do?  It'll create a separate copy of the project that you are able to modify, so that you can then make changes when you fix a bug later on.

![fork](https://user-images.githubusercontent.com/12502294/53657415-19bfcc00-3c24-11e9-9b58-11f059fb0950.png)

Next, if you don't already have a Git client installed on your computer, [download and install one](https://git-scm.com/download/).  You'll want one for cloning the project (downloading a copy of it locally) and for _pushing_ your changes (uploading your changes back to your repository) once you're done.  If you know what you're doing, you can change the installation settings, but the default ones are fine as well.

If you haven't used Git before, we suggest you use the Git Gui client, as it's the easiest to get started with.  When it launches, enter in the URL of your forked repository (which should be `https://github.com/<your username>/EclipseTutorial`) and the folder on your computer you want to save it to.

![git_clone](https://user-images.githubusercontent.com/12502294/53658245-3c52e480-3c26-11e9-92c6-d626abfae450.png)

Then, click the "Clone" button, and Git will clone a copy of your repository onto your local computer.

You should then see something like the following:
![git_cloned](https://user-images.githubusercontent.com/12502294/53658378-9784d700-3c26-11e9-8cfb-aad4bcc384f0.png)

At this point, you have a copy of the project on your computer ready to go.  You can now import it into Eclipse, and begin with the next section of this workshop!

## Eclipse Intro

Eclipse, like any modern IDE, contains a number of really cool features that, if used properly, make our lives as developers much more productive.  The aim of this workshop is to introduce you to a few of them, so that you have a more productive experience in CSC326 and beyond.  If you don't have Eclipse installed already, you'll want to [download](https://www.eclipse.org/downloads/) it and install it now.  Launch the installer, and you should be greeted with a window like the following:

![eclipse_installer](https://user-images.githubusercontent.com/12502294/53658623-475a4480-3c27-11e9-8bdf-a5efaaebbe03.png)

Select the "Eclipse IDE for Java Developers" option, and install Eclipse.  You can safely choose all of the default options, and then launch it once it's done installing.  You can safely close the Intro screen.  Then, right-click in the Package Explorer on the left side, and select Import -> Maven -> Existing Maven Projects, and browse to where you cloned this workshop.  Yo ucan use the Java files included here to follow along with the rest of this workshop.

## General/High-Level Features

There are a lot of small things in Eclipse that while barely worth mentioning on their own are nice once they become muscle memory:

* Open Type (Ctrl + Shift + T): Available from anywhere in Eclipse, this opens up a window that lets you immediately search for any Java type.  This includes both Java classes you've defined and types available in the Java library and libraries you're using.  Case insensitive, and even for any `*.java` file (so, Interfaces and Enums and such, too):
![search_type](https://media.github.ncsu.edu/user/2943/files/4e787fd0-7f0c-11e8-8a96-4a01aaf16fe1)

* Open Resource (Ctrl + Shift + R): Available from anywhere in Eclipse, this does the same as above except it lets you search for any _resource_ within your workspace.  This will include non-Java files (such as `.properties`, `.html`, and `.js` files) but doesn't search outside the workspace (so, while it will find a `UniversalDAO.java` defined within your workspace, it won't find `java.lang.String`).  Particularly useful for finding HTML files.
![search_resources](https://media.github.ncsu.edu/user/2943/files/c093c566-7f0c-11e8-8361-266e4416e86f)

* Jump to Line (Ctrl + L): Available while you have a file open, jumps to the line you then enter.  Nice for large files.

* Inspect File (Ctrl + O): Shows you the structure of a Java or (less competently) HTML file.  Very nice in a Java class, as it'll tell you all of the fields, methods, and inner classes defined within the current file.  You can also use this to look at the structure of a HTML file, but given that it starts minimized and HTML is often heavily nested, I'm not sold on the value of this.

![inspect_class](https://media.github.ncsu.edu/user/2943/files/4e27ebba-7f0c-11e8-95f7-8581054fb5da)

* Open Terminal (Ctrl+Alt+Shift+T or small monitor icon in the toolbar): Opens a terminal.  If there are multiple available, you can choose:

![open_terminal](https://media.github.ncsu.edu/user/2943/files/4e5f1e6e-7f0c-11e8-85f2-9365d7002cbb)

I like this because it lets you use the command-line Git client from right within Eclipse.

* Jump to Declaration (Ctrl + Click or select + F3): Works on any method call, variable name, or type name, and instantly takes you to the declaration of that method/variable/class.  For instance, if we click on `invoke` from `final Object resultSetValue = retrieveWith.invoke( rs, getColumnForField( field ) );` it takes us to `java.lang.reflect.Method.invoke(Object, Object...)`.  Really nice for jumping around quickly.

* Optimize Imports (Ctrl + Shift + O): Works in any Java file; will automatically optimize imports, adding ones you need and removing ones you don't.  If it can't figure out what type to use (for instance, `java.util.List` vs `java.awt.List`) it'll prompt you, but otherwise does it automatically.  Note that it doesn't like imports like `import java.lang.*` and will break it apart into just the ones that you're actually using.

* Autoformat (Ctrl + Shift + F): Works in any Java file; will automatically autoformat your code according to the rules you've defined (and should have imported).  There's no excuse for messy code when this exists.

* Workspace Search (Ctrl + H): Compared to Ctrl + F, which just searches the current file, this will let you search anything you want.  I usually use the "File Search" tab and the File Name Patterns to restrict the search to just files of a certain type (for instance, Java files).  Supports regular expressions too.

* In-Line Warnings: The Eclipse Java compiler will not just provide in-line compilation errors, but in-line compilation _warnings_ as well.  While all of these are good to pay attention to, one that's particularly nice is a warning on unlikely types for `Object.equals()`.  The `equals()` method compares on not just value, but also type, so if the types don't match will never return true.  The compiler warns you when you've made this mistake:
![equals_warning](https://media.github.ncsu.edu/user/2943/files/e0397f62-7f81-11e8-82e1-21e448890c18)

* AutoComplete (Ctrl + Space): You can use the autocomplete to fill in Java types, references to variable names, or method calls.  I find this particularly useful when I want to take a quick look at what methods are available on some unfamiliar object I'm working with.  To do this, just type `<<variableName>>.` and hit Ctrl+Space and it'll show you any method you can call on that.  If there are multiple options available, it'll give you all available ones to pick from.



## Eclipse Debugger

Eclipse is great for many reasons, but the debugger is probably my favorite.  While you can get everything else through more primitive tools, there really is no good alternative to a good debugger.  To use the debugger, just make sure to start your applications in Debug Mode (Debug As -> Java Application, or Debug As -> Maven Build), and then any breakpoints that you place will launch the debugger.  The first time you do this, you'll probably get a message asking you to confirm you want to switch to the debugger.

![confirm_switch](https://media.github.ncsu.edu/user/2943/files/4daaf880-7f0c-11e8-929b-00beea7a34db)

Go ahead and click "Remember my decision" and "Yes" to automatically switch any time breakpoints are hit in the future.

At a high level, the Eclipse debugger looks something like the following:
![debugger_main_annotated](https://media.github.ncsu.edu/user/2943/files/4e18219e-7f0c-11e8-9adf-459f6fd3ad1d)

Although this view can be customized, as with the rest of Eclipse, by dragging and dropping different views around, I find something like this to be the most productive.  There are five main areas I find useful:

1. The "Debug" view, or the call stack.  This shows what series of method calls have lead us to where we currently are.  The most recent method is the one shown at the very top, and the one that called it right below it, and the one that called that below that, and so on.

2. The control buttons.  These are used to tell the debugger what to do and access other functionality within Eclipse.

3. The "Variables" view shows you the value of all live variables.  That is, given where we currently are, these are all variables that have been declared in the local scope.  Global variables aren't displayed here.  If you click on a variable, it's value will show up below the faint dividing line.  However, the value also shows up under the "Value" column, so I've found this is really only useful if you're trying to work with multiline strings.

4. The "Code" view shows you your various workspace resources.  While you can have any file type opened here, the Eclipse debugger only works on Java code (and not on JavaScript or SQL or the like) so you're most likely to have a bunch of those open.  The line you're currently at, or the next line that is going to be executed, is highlighted in green.  Any breakpoints present are shown as blue dots on the left side.  A solid blue dot is an "enabled" breakpoint (one the debugger will stop at when hit); a hollow blue dot is a "disabled" one that it will skip over.

5. The console, just like you've seen.  While we're not writing console applications here, it's useful for the debug messages printed out by our frameworks (Spring and Hibernate).



### Additional Functionality
There's  more to some of these than immediately meets the eye.  Some additional behavior/functionality:

#### Call Stack

Any non-trivial program ought to have its logic broken up into many different methods.  Often times, it's helpful to know how you ended up in the current method, that is, what series of method calls led you to this.  In its most basic state, that's what the Debug view will show you.  Often, however, in addition to seeing just what method calls took you to the current point, it's useful to see the variables and flow of control within each that took you here.  Clicking a different method here will let you instantly "unwind" and "rewind" the stack to jump back and forth between them.  For example, clicking on the element for `UniversalDAO<T>.find(Integer):77` will unwind us to that location in that method:
![callstack_rewind](https://media.github.ncsu.edu/user/2943/files/4ea34c7e-7f0c-11e8-9884-a7fbab0e26e9)
From here, you can poke around, looking at any variables that you want, and then when you're satisfied, you can click back on the method at the top to go back to it.

#### Debugger Control Buttons
The debugger offers a number of useful control buttons.  Some I like:
* Skip All Breakpoints (Ctrl + Alt + B): Represented by a blue dot with a line through it, and just to the left of the "Play" button, this tells the debugger to skip all breakpoints.  Useful for running through code quickly to see if it's working correctly.  Clicking it again turns it off.
* Step Into (F5): Represented by an arrow pointing down between two dots, this will step into the next method call.  If there are multiple method calls on a line, this will step into the first one.  For instance, clicking "Step Into" when the instruction pointer is at `if ( method.getName().equals( methodName ) )` will step into `getName()`.

* Step Over (F6): Represented by an arrow pointing over a dot: This will step over next line of code.  Useful for running a small-ish piece of code to see what happens.

* Step Out (F7): Represented by an arrow pointing up between two dots, this will step out of the current method call.  Useful when you want to return from the current method to the one that called it.

* Drop to Frame (no shortcut): Represented by three horizontal lines and an arrow, this will drop you to the top of the current method.  Useful when you want to "replay" it by starting again from the top.  If the method is not idempotent (that is, it has some sort of side-effects, like writing to a database) this can possibly cause issues.  However, for pure functional methods, that just read and compute, it's always safe.


#### Code View
As expected, this lets you see what code you're actually debugging.  This can be either Java code that you've directly written, or something within the Java language or a library you're using (this should be supported automatically; if not see [this](https://dzone.com/articles/attaching-java-source-eclipse)).  Either way, it will show you the source code you're working with, and let you inspect things in real-time as it runs through.  However, there's a lot you can do with this:
* For any variable that is in scope (that is, it's been declared by the line in code the instruction is at) you can hover over it to see the value.  This works both for the variables shown in the "Variables" view (3) and global variables not shown there.  Often it's quicker to look at them here.  You can also select them and right-click and then hit "Inspect" or "Ctrl + Shift + I" but there's not really a good reason to do it like that when hovering over it works.

* For any legal operation (for instance, an arithmetic operation like `x + y` or method invocation like `"abc".contains("b")`) you can select it and hit "Ctrl + Shift + I" to execute that piece of code and run the result.  This is useful when you have multiple method calls chained together without being assigned to intermediate variables; for instance, we can do:
![inspect_statement](https://media.github.ncsu.edu/user/2943/files/4e4dd384-7f0c-11e8-8441-873039db53f8)
Hitting "Ctrl + Shift + I" again will, as indicated, move this to an "Expressions View" which gives you the ability to keep watching this expression at all times, just like for variables.  I don't find it too useful, but it's there if you want it.

* To extend upon the last point: you can execute _anything_, regardless of whether it was actually in the original code or not.  So, if you get to a point and then wish you knew what the value of some evaluation was, you can just type it, select it, and then hit Ctrl + Shift + I to evaluate it on the fly.  For example:
![inspect_fragment](https://media.github.ncsu.edu/user/2943/files/4e3b8616-7f0c-11e8-89f0-03f9f620c77b)
Note that you don't even have to put semicolons at the end, because you're just inspecting a fragment rather than running an entire program.  Probably a good idea to Ctrl+Z to remove any invalid code when you're done though.


### Miscellaneous things
* Pause on Exception:  Think you're hitting an exception somewhere, and it's causing the issue you're seeing even though it's caught somewhere else?  Click on the "Breakpoints" window, then the icon that looks like "J!", and then type in part of the name you're looking for (wildcards are allowed):
![catch_exception](https://media.github.ncsu.edu/user/2943/files/4d93b7c4-7f0c-11e8-8075-9a58488d22b0)
You can configure it to pause on either caught or uncaught exceptions, or both.  If you think the problem is from a caught exception, it can be useful to check that box.  Click OK and this will give you a breakpoint that functions like any other.
* Clicking on a line in the current method and then hit "Ctrl + R" will run to that line.  Easy to jump over large blocks of code at once.

## Activity

Once you have everything imported, you'll see there are two files: `ArrayList.java`, an implementation of a simple array-based List, and `ArrayListTest.java`, a set of unit tests for the functionality to ensure that it works.  

Unfortunately, there's a bug in the ArrayList implementation.  Run the tests, and you'll see that one of them is failing.  Once you've found the failing test, go back to your Git repository (that you created above).  Click on the "Issues" tab, then "New Issue", and create an Issue that represents the bug that you found in the sytem.  Describe the bug as best as you can, including what you think might be causing it.

The activity today is to figure out what's causing this bug.  We encourage you to use the Eclipse debugger to uncover the source of this bug.  To do so, instead of clicking Run As -> JUnit Test, click Debug As -> JUnit Test.  Go back to Eclipse, and work on fixing the bug in the system.  When you have it fixed, and the tests are all passing, go back to the Git client.  Hit the F5 key, or Commit->Rescan from the menu.  The Git client will show you a preview of what files you've changed:

![git_client](https://user-images.githubusercontent.com/12502294/53659258-17ac3c00-3c29-11e9-8986-18c12a73fa5a.png)

Right-click on the file, and select "Stage Hunk For Commit", which adds it to the list of files that will get included with the next commit.  Then, in your commit message, enter "Fixes #1" to indicate that this fixes the Issue that you created earlier.  Finally, click the "Push" button.  If you get a popup button, click "Push" in it too.  You should see a confirmation message that everything was pushed successfully!

Now, check your forked Git repository that you created at the beginning of this workshop.  You should see that there's a new commit, and that the Issue you created has been closed.  How did that happen?  Git saw the "Fixes #1" message that you added to your commit, and realised this must be a fix for the Issue that was opened.

Congratulations, you've now created your own Git repository, documented a bug, and then fixed it!
