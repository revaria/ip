# Caesar User Guide

> I came, I saw, I conquered.

Caesar is a desktop archive for the busy Roman commander, designed to help you track your conquests (tasks) via a fast and efficient Command Line Interface (CLI).

## Quick Start

Ensure you have Java 11 or above installed.

Download the latest caesar.jar from here.

Open a terminal, navigate to the folder, and run:
java -jar caesar.jar

The Caesar logo will appear—you are ready to begin!

## Features

1. Adding Tasks
Caesar supports <ins>three</ins> types of tasks:
   - Todo: A basic task without a deadline.
     - `todo <description>`
     - Example: `todo Recruit 10th Legion`

   - Deadline: A task with a specific cutoff date.
     - `deadline <description> /by <yyyy-mm-dd HHmm>`
     - Example: `deadline Cross the Rubicon /by 2026-03-15 0800`

   - Event: A task with a start and end time.
     - `event <description> /from <yyyy-mm-dd HHmm> /to <yyyy-mm-dd HHmm>`
     - Example: `event Senate Meeting /from 2026-03-15 1000 /to 2026-03-15 1200`


2. Viewing the Archives
To see all currently tracked tasks:
   - `list`


3. Managing Progress
   - Mark Task:
     - `mark <index>`
   - Unmark Task:
     - `unmark <index>`
   - Delete Task:
     - `delete <index>`


4. Searching for Tasks
Find tasks using keywords in their descriptions.  
Caesar supports the use of **one or more** keywords:
   - `find <keyword> ... <keyword>`
   - Example: `find Legion march` (Returns all tasks containing 'Legion' or 'march')


## FAQ
Q: Where is my data saved?

A: Caesar automatically saves your tasks in ./data/caesar.txt. **Do not edit** this file manually unless you wish to risk the wrath of the Senate!

# Command Summary
| Action | Command Format | Example |
| :--- | :--- | :--- |
| **Todo** | `todo <description>` | `todo Recruit 10th Legion` |
| **Deadline** | `deadline <description> /by <YYYY-MM-DD HHmm>` | `deadline Cross Rubicon /by 2026-03-15 0800` |
| **Event** | `event <description> /from <time> /to <time>` | `event Senate Meeting /from 1000 /to 1200` |
| **List** | `list` | `list` |
| **Mark** | `mark <index>` | `mark 1` |
| **Unmark** | `unmark <index>` | `unmark 1` |
| **Delete** | `delete <index>` | `delete 2` |
| **Find** | `find <keyword>` | `find Legion` |
| **Exit** | `bye` | `bye` |
