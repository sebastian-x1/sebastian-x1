<!--
This is a Markdown text file.  For information about using the Markdown markup langauge see the following site: https://www.markdownguide.org/
-->

# Farkle!

This project is an implementation of the *Farkle* dice game using the Java programming language.

## Building

To build and run *Farkle*, you must install the Java [JRE](https://www.java.com/en/download/manual.jsp) and [JDK](https://www.oracle.com/java/technologies/downloads/).

Optionally an IDE (Integrated Development Environment) such as [Eclipse](https://www.eclipse.org/downloads/) may be used.  To import the project into Eclipse use File => Import => _________________.

*This section is a work in progress.*

## Playing

*This section is a work in progress.*

## Contributors Guide

### Project Structure

The project is organized as follows:

- Farkle/
  - diagrams/
    - *UML class & program flow diagrams*
  - screenshots/
    - *demostrations of program & images displayed in REAMDE*
  - src/
    - farkle/
      - *Java source files within the farkle package*
  - .classpath - *Eclipse project file*
  - .gitignore - *Contains patterns which remove certain files from Git*
  - .project - *Eclipse project file*
  - README.md - *Repository README text file*

### Using GitHub Desktop

GitHub Desktop is a client for interacting with Git repositories hosted on GitHub.  Before installing GitHub Desktop, make sure you have Git installed on your system.  For Windows, select the **64-bit Git for Windows Setup** on this webpage: [Git - Download for Windows](https://git-scm.com/download/win).  Run the installer and complete the steps (simply choose the default options).

You can download GitHub Desktop on this webpage: [GitHub Desktop | Simple collaboration from your desktop](https://desktop.github.com/).  After installing, start the program and login to your GitHub account.

For the purpose of our project we only need to use the following basic operations of Git:
 
 - Cloning a repository
 - Retrieving/pulling changes from the remote repository
 - Staging changes & creating commits
 - Publishing/pushing commits to the remote repository

The following pages are all resources for using GitHub Desktop:

 - [How to Use GitHub Desktop Tutorial for Beginners](https://www.youtube.com/watch?v=MaqVvXv6zrU&ab_channel=CameronMcKenzie)
 - [Getting Started with Git and GitHub Desktop | Codecademy](https://www.codecademy.com/article/what-is-git-and-github-desktop)
 - [GitHub Desktop documentation - GitHub Docs](https://docs.github.com/en/desktop)

#### Cloning the Repository

Open GitHub Desktop and click **File -> Clone repository...** in the application menu.  In the "Clone a repository" menu select the **URL** tab.  In the field labeled **Repository URL or GitHub username and repository**, enter the following URL: *https://github.com/cppimmo/Farkle.git*  In the field labeled **Local path**, choose the location of your Eclipse workspace folder (If you aren't sure where this is, start Eclipse and it should show you the path of your most recently used workspace).  Now click the **Clone** button.

Now open Eclipse.  To import the local repository as a Java project in your Eclipse workspace, click **File -> Import -> General -> Existing Projects into Workspace** and click **Next**.  Now click **Browse...** and select your Eclipse workspace folder where you cloned the repository to.  Click **Select All** and then click **Finish**.

![Project Import](screenshots/project_import.png)

#### Publishing and Retrieving Changes

As you make changes to code in Eclipse or files within your local repository, you will eventually want to share them with others via commits.

In the following example, the README.md file at the root of the local repository has been modified.

![Committing](screenshots/gh_commit.png)

To stage the change for inclusion in the next commit, select the checkbox next to the filename.  Note that all changes may be staged at once using the uppermost checkbox.  Enter a message that describes your changes within the box labeled **Summary (required)**.  Now click **Commit to master**.  Your changes will then be stored locally as a commit.

In order for others to access your commit(s), you must publish it to the current branch in an operation called **push**ing.  To push your commit(s), click **Repository -> Push** in the application menu.

Periodically you will want to retrieve commits that other group members have published to the repository in an operation called **fetch**ing.  To fetch commits that others have published, click **Repository -> Fetch** in the application menu.

You can browse the local repository commit history by clicking **View -> History** in the application menu.  You can also browse through the remote repository commit history at: [Commits - cppimmo/Farkle](https://github.com/cppimmo/Farkle/commits/master).

### Editing UML Diagrams

Our UML class and program flow diagrams are located in the *diagrams/* directory.  They are created using the Graphor program which you can download [here](https://gaphor.org/download/)

To open one of our existing diagrams with Graphor for editing, press the **F10** key on your keyboard and click **Open Model**.  Then navigate to and select the *.graphor* file on your computer.  When you finish making your changes press the combination **Ctrl + S** on your keyboard.

The screenshot below demonstrates Graphor's appearance:

![Graphor](screenshots/graphor_appearance.png)

For a tutorial on using Graphor see [Get Started with Graphor](https://docs.gaphor.org/en/latest/getting_started.html).  For a cheat sheet on using UML see [UML Diagram Cheat Sheet and Reference Guide](https://www.guru99.com/uml-cheatsheet-reference-guide.html)
