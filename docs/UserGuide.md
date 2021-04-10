---
layout: page
title: User Guide
---
## Table of Contents
* [Introduction](#introduction)
* [Feature List](#feature-list)
  * [General Commands](#general-commands)
  * [Task-Specific Commands](#task-specific-commands)
  * [Event-Specific Commands](#event-specific-commands)
  * [Commands Related to Both Task and Event](#commands-related-to-both-task-and-event)
* [Public Parameters for Tasks and Events](#public-parameters-for-tasks-and-events)
  * [Common to both Task and Event](#common-to-both-task-and-event)
  * [Task-Specific](#task-specific)
  * [Event-Specific](#event-specific)
* [Quick start](#quick-start)
* [Features](#features)
* [FAQ](#faq)
* [Command Summary](#command-summary)



## Introduction
SOChedule is a one-stop solution for NUS School of Computing (SoC) students to manage their tasks and events effectively.
Targeted at users who can type fast and prefer typing to mouse input, SOChedule is optimized for use via a Command Line Interface (CLI) 
while still having the benefits of a Graphical User Interface (GUI).

## Feature List

### General Commands
* Viewing help: [`help`](#viewing-help-help)
* Exiting the program: [`exit`](#exiting-the-program-exit)
  
### Task-Specific Commands
* Adding a task: [`add_task`](#adding-a-task-add_task)
* Deleting a task: [`delete_task`](#deleting-a-task-delete_task)
* Editing a task: [`edit_task`](#editing-a-task-edit_task)
* Listing all tasks: [`list_task`](#listing-all-tasks-list_task)
* Marking one or more tasks as done : [`done_task`](#marking-one-or-more-tasks-as-done-done_task)
* Marking a task as uncompleted : [`undone_task`](#marking-a-task-as-uncompleted-undone_task)
* Getting today's tasks: [`today_task`](#getting-todays-tasks-today_task)
* Finding tasks by name: [`find_task`](#finding-tasks-by-name-find_task)
* Sorting all tasks: [`sort_task`](#sorting-all-tasks-sort_task)
* Pinning a task: [`pin_task`](#pinning-a-task-pin_task)
* Unpinning a task: [`unpin_task`](#unpinning-a-task-unpin_task)
* Clearing completed tasks: [`clear_completed_task`](#clearing-completed-tasks-clear_completed_task)
* Clearing expired tasks: [`clear_expired_task`](#clearing-expired-tasks-clear_expired_task)
  
### Event-Specific Commands
* Adding an event: [`add_event`](#adding-an-event-add_event)
* Deleting an event: [`delete_event`](#deleting-an-event-delete_event)
* Editing an event: [`edit_event`](#editing-an-event-edit_event)
* Listing all events: [`list_event`](#listing-all-events-list_event)
* Getting today's events: [`today_event`](#getting-todays-events-today_event)
* Finding events by name: [`find_event`](#finding-events-by-name-find_event)
* Clearing expired events: [`clear_expired_event`](#clearing-expired-events-clear_expired_event)

### Commands Related to Both Task and Event
* Finding tasks and events before or on a given date: [`find_schedule`](#finding-tasks-and-events-before-or-on-a-given-date-find_schedule)
* Finding free time slots: [`free_time`](#finding-free-time-slots-free_time)
* Summarising tasks and events completion status: [`summary`](#summarising-tasks-and-events-statistics-summary)
* Clearing Sochedule: [`clear`](#clearing-sochedule-clear)

[Return to Table of Contents](#table-of-contents)

## Public Parameters for Tasks and Events
As listed below are the attributes to be specified for Tasks and Events. All parameters are mandatory unless otherwise stated.

### Common to both Task and Event

<table>
    <tr>
        <th>Attribute</th>
        <th>Identifier</th>
        <th>Restriction(s)</th>
    </tr>
    <tr>
        <td><code>Name</code></td>
        <td><code>n/</code></td>
        <td>
            <ul>
                <li>Maximum 30 characters in length</li>
            </ul>
        </td>
    </tr>
    <tr>
        <td><code>Category</code></td>
        <td><code>c/</code></td>
        <td>
            <ul>
                <li>Maximum 15 characters in length each</li>
                <li>None, single or multiple Categories can be assigned to a single element</li>
                <li>No spaces are allowed</li>
            </ul>
        </td>
    </tr>
    <tr>
        <td><code>Tag</code></td>
        <td><code>t/</code></td>
        <td>
            <ul>
                <li>Maximum 15 characters in length each</li>
                <li>None, single or multiple Tags can be assigned to a single element</li>
                <li>No spaces are allowed</li>
            </ul>
        </td>
    </tr>
</table>

### Task-Specific

<table>
    <tr>
        <th>Attribute</th>
        <th>Identifier</th>
        <th>Restriction(s)</th>
    </tr>
    <tr>
        <td><code>Deadline</code></td>
        <td><code>d/</code></td>
        <td>
            <ul>
                <li>Follows the format YYYY-MM-DD</li>
                <li>Must be a date later than or on the date of task creation</li>
            </ul>
        </td>
    </tr>
    <tr>
        <td><code>Priority</code></td>
        <td><code>p/</code></td>
        <td>
            <ul>
                <li>Single digit integer ranging from 0 to 9 inclusive</li>
                <li>0 is highest in priority, while 9 is lowest</li>
            </ul>
        </td>
    </tr>
</table>

### Event-Specific

<table>
    <tr>
        <th>Attribute</th>
        <th>Identifier</th>
        <th>Restriction(s)</th>
    </tr>
    <tr>
        <td><code>Start Date</code></td>
        <td><code>sd/</code></td>
        <td>
            <ul>
                <li>Follows the format YYYY-MM-DD</li>
                <li>Date earlier than date of creation allowed (for ongoing events)</li>
            </ul>              
        </td>
    </tr>
    <tr>
        <td><code>End Date</code></td>
        <td><code>ed/</code></td>
        <td>
            <ul>
                <li>Follows the format YYYY-MM-DD</li>
                <li>Must be a date later than or on the date of creation</li>
                <li>Must be a date after or on start date (Subject to Time attribute constraints)</li>
            </ul>
        </td>
    </tr>
    <tr>
        <td><code>Start Time</code></td>
        <td><code>st/</code></td>
        <td>
            <ul>
                <li>Follows the format of hh:mm, in a 24-hour format</li>
            </ul>
        </td>
    </tr>
    <tr>
        <td><code>End Time</code></td>
        <td><code>et/</code></td>
        <td>
            <ul>
                <li>Follows the format of hh:mm, in a 24-hour format</li>
                <li>If start date is the same as end date, end time must be a time after start time</li>
            </ul> 
        </td>
    </tr>
</table>

[Return to Table of Contents](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `SOChedule.jar` from [here](https://github.com/AY2021S2-CS2103-W16-1/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your SOChedule.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. A sample SOChedule is given below. There would not be pre-entered data on first launch so that users can immediately jump in and use.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list_task`** : Lists all tasks.

   * **`add_task`**`n/CS2103 assignment d/2021-04-07 p/1 c/schoolwork t/urgent` : Adds a task named `CS2103 assignment` to the SOChedule with its respective attributes. Please verify the validity of the date parameter.

   * **`delete_task`**`3` : Deletes the 3rd task shown in the current list.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

[Return to Table of Contents](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `undone_task INDEX`, `INDEX` is a parameter which can be used as `undone_task 1`.

* Items in square brackets are optional.<br>
  e.g `n/TASKNAME [t/TAG]` can be used as `n/Quiz t/CS2103` or as `n/Quiz`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* If a parameter is expected only once in the command, but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/1 p/2`, only `p/2` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `list_task`, `list_event`) will be ignored.<br>
  e.g. if the command specifies `list_task 123`, it will be interpreted as `list_task`.

</div>

[Return to Table of Contents](#table-of-contents)

### Viewing help: `help`
Shows a message explaining how to access the help page.
![helpMessage](images/helpMessage.png)

[Return to Feature List](#feature-list)


### Adding a task: `add_task`
Adds a task into the task list.

Format: `add_task n/TASKNAME d/DEADLINE p/PRIORITY [c/CATEGORY]... [t/TAG]...`
* `n/` is followed by the task name.
* `d/` is followed by the date, with the format YYYY-MM-DD, deadline cannot be a past date.
* `p/` is followed by the priority, with 0 being highest and 9 being lowest. Other inputs are not accepted.
* `c/` is followed by the category. It is optional.
* `t/` is followed by the tag. It is optional.

Examples:
* `add_task n/CS2103 assignment d/2022-02-27 p/1 c/schoolwork t/urgent` adds a new task named "CS2103 assignment" with the respective parameters.
* `add_task n/CCA admin work d/2022-02-28 p/2 c/CCA` adds a new task "CCA admin work" with the respective parameters.

[Return to Feature List](#feature-list)


### Deleting a task: `delete_task`
Deletes a task from the task list.

Format: `delete_task INDEX`
* Deletes the task at the specified INDEX.
* The index refers to the index number shown in the displayed task list.
* The index must be a positive and valid integer 1, 2, 3, ...

Examples:
* `delete_task 2` deletes the second task in the task list.

[Return to Feature List](#feature-list)


### Editing a task: `edit_task`
Edits an **existing and uncompleted** task in the task list.

Format: `edit_task INDEX [n/TASKNAME] [d/DEADLINE] [p/PRIORITY] [c/CATEGORY]... [t/TAG]...`
* Edits the task at the specified `INDEX`. 
  The index refers to the index number shown in the displayed task list. 
  The index must be an **integer larger than zero**. A valid example can be `1`.
* You can only edit an **existing and uncompleted** task.
* **At least one** of the optional fields must be provided.
* The `DEADLINE` provided cannot be earlier than today.
* Existing values will be updated to the input values.
* If the index provided is a negative integer or zero, an error message indicating invalid command format will be returned.
* If the index provided is larger than `2147483647`(i.e. larger than the maximum value of `Integer` object in Java),
  it is not a valid integer in our definition.
  Thus, an error message indicating invalid command format will be returned.
* When editing tags/categories, the existing tags/categories of the task will be removed i.e. adding of tags/categories is not cumulative.
* You can remove all the task’s tags by typing `t/` without specifying any tags after it.
  Similarly, you can remove all the task’s categories by typing `c/` without specifying any categories after it.
* When editing tags, the order of tags given in the input and the order of tags shown in the UI can be different. 
  For example, in input `edit_task 1 t/tag1 t/tag2`, `t/tag1` is before `t/tag2`, 
  but `tag2` may appear in the UI before `tag1`, then `tag1` on the right of `tag2`. 
  The ordering is not guaranteed and this is intended behaviour.
* When editing a task, error messages will be shown if the edited task is the same as the original task or the edited task is
equivalent to another existing task in the task list.

Examples:
* `edit_task 1 n/t1` edits the name of the first task (if present in SOChedule) to be `editedTaskName`.
* `edit_task 2 p/3 t/` edits the priority of the second task (if present in SOChedule) to be `3` and clears all existing tags. 

#### Illustration of usage of `edit_task`:
![Example of usage of `edit task`](images/EditTaskUsage.png)

[Return to Feature List](#feature-list)


### Listing all tasks: `list_task`
Lists all tasks from the task list.

Format: `list_task`

[Return to Feature List](#feature-list)


### Marking one or more tasks as done: `done_task`
Marks one or more task from the task list as completed.

Format: `done_task INDEX1 [INDEX2] ...`
* Marks the task(s) at the specified INDEX(es) as complete. 
  The index refers to the index number shown in the displayed task list.
  The index must be an **integer larger than zero**. A valid example can be `1`.
* When multiple indexes are provided, they need to be separated by a whitespace, e.g. `1 2`.
* All specified tasks must be **uncompleted and existing** before calling this command.
* If more than 1 indexes are provided, these indexes **cannot contain duplicates**. 
  Otherwise, an error message indicating invalid command format will be returned.
* If the index provided is a negative integer or zero, an error message indicating invalid command format will be returned. 
* If the index provided is larger than `2147483647`(i.e. larger than the maximum value of `Integer` object in Java), 
  it is not a valid integer in our definition. 
  Thus, an error message indicating invalid command format will be returned.

Examples:
* `done_task 1 2` marks the first and second task in the task list as completed.

#### Illustration of usage of `done_task`:
![Example of usage of `done task`](images/DoneTaskUsage.png)

[Return to Feature List](#feature-list)


### Marking a task as uncompleted: `undone_task`
Marks a completed task from the task list as uncompleted.

Format: `undone_task INDEX`
* Marks the task at the specified INDEX as uncompleted.
  The index refers to the index number shown in the displayed task list.
  The index must be an **integer larger than zero**. A valid example can be `1`.
* The specified task must be completed before calling this command.
* If the index provided is a negative integer or zero, an error message indicating invalid command format will be returned.
* If the index provided is larger than `2147483647`(i.e. larger than the maximum value of `Integer` object in Java),
  it is not a valid integer in our definition.
  Thus, an error message indicating invalid command format will be returned.

Examples:
* `undone_task 1` marks the first task in the task list as uncompleted.

#### Illustration of usage of `undone_task`:
![Example of usage of `undone task`](images/UndoneTaskUsage.png)

[Return to Feature List](#feature-list)


### Getting today's tasks: `today_task`
Lists all tasks that have deadline on today from the task list.

Format: `today_task`

[Return to Feature List](#feature-list)


### Finding tasks by name: `find_task`
Finds tasks whose names contain any of the given keywords from the task list.

Format: `find_task KEYWORD [MORE_KEYWORDS]`
* The search is case-insensitive. e.g. `homework` will match `Homework`.
* The order of the keywords does not matter. e.g. `Practice Problems` will match `Problems Practice`.
* Only the name of the tasks is searched.
* Only full words will be matched. e.g. `CS` will not match `CS2103`.
* Tasks matching at least one keyword will be returned (i.e. `OR` search). e.g. `CS2103 Homework` will return 
  `ST2131 Homework`, `CS2103 Quiz`.
  
Examples:
* `find_task Homework` returns `st2131 homework` and `Homework 1`
* `find_task assignment homework` returns `Assignment 1`, `Homework 2`
![find_task example](images/find_task-example.png)

[Return to Feature List](#feature-list)


### Sorting all tasks: `sort_task`
Sorts the task list.

Format: `sort_task ARGUMENT`
* Sorts task list and updates UI based on supplied argument.
* Accepted arguments (case-sensitive):
   * `name`: Sorts by task name, in increasing lexicographical order
   * `deadline`: Sorts by task deadline, in increasing date order
   * `completion`: Sorts by task completion status, with completed tasks at the bottom
   * `priority`: Sorts by task priority, in decreasing order, from priority 0 on top, to priority 9 at the bottom
* On subsequent boots, the following will happen:
   * Relative order from previous launch will be preserved.
   * However, if any order-altering command is issued, tasks will be sorted by name by default, unless otherwise stated by another `sort_task` command.
    
Examples:
* `sort_task completion` sorts the task list by completion status.
* `sort_task name` sorts the task list by name.

#### Illustration of usage of `sort_task`:
![Example of usage of `sort_task`](images/SortTaskUsage.png)


[Return to Feature List](#feature-list)


### Pinning a task: `pin_task`
Pins a task from the task list.

Format: `pin_task INDEX`
* Pins the task at the specified INDEX.
* Already pinned tasks will be unable to be pinned a second time.
* The index refers to the index number shown in the displayed task list.
* The index must be a positive and valid integer 1, 2, 3, ...
* After pinning, the Task List will be sorted either according to previously entered `sort_task` command, or name (by default). See [here](#illustration-of-the-interaction-between-pin_task-and-sort_task).
    * Should there be two or more pinned tasks, the pinned tasks will be sorted as well.
    * Only the fact that pinned tasks will appear over the unpinned tasks is guaranteed. Internal order of pinned tasks is not persistent over `sort_task`.
* Pinned tasks are persistent over instances of SOChedule.

Examples:
* `pin_task 1` pins the first task in the task list

#### Illustration of usage of `pin_task`:
![Example of usage of `pin_task`](images/PinTaskUsage.png)

#### Illustration of the interaction between `pin_task` and `sort_task`:
![Example of interaction of `pin_task` with `sort_task`](images/PinTaskInteractionWithSortTask.png)

[Return to Feature List](#feature-list)


### Unpinning a task: `unpin_task`
Unpins a task from the task list.

Format: `unpin_task INDEX`
* Unpins the task at the specified INDEX.
* Follows similar restrictions to `pin_task`

Examples:
* `unpin_task 1` unpins the first task in the task list

#### Illustration of usage of `unpin_task`:
![Example of usage of `unpin_task`](images/UnpinTaskUsage.png)

[Return to Feature List](#feature-list)


### Clearing completed tasks: `clear_completed_task`
Clear tasks marked as completed from the task list.

Format: `clear_completed_task`
* If there's no completed task in the list (or even no any task in the list), this command is still able to be executed
and return success message `Completed tasks (if any) have been cleared!` (In this case, no task is cleared since no task is completed.)

#### Illustration of usage of `clear_completed_task`:
![Example of usage of `clear_completed_task`](images/ClearCompletedTaskUsage.png)

[Return to Feature List](#feature-list)


### Clearing expired tasks: `clear_expired_task`
Clear tasks with past deadlines from the task list.

Format: `clear_expired_task`
* For a task to be considered expired, the task should have past deadline compare to the local date on the user's computer, 
hence changing of date on a computer could affect the judgement of expiration.
* If there's no expired task in the list (or even no any task in the list), this command is still able to be executed
and return success message `Expired tasks (if any) have been cleared!` (In this case, no task is cleared since no task is expired.)

#### Illustration of usage of `clear_expired_task`:
![Example of usage of `clear_expired_task`](images/ClearExpiredTaskUsage.png)

[Return to Feature List](#feature-list)


### Adding an event: `add_event`
Adds an event to the event list.

Format: `add_event n/EVENTNAME sd/STARTDATE st/STARTTIME ed/ENDDATE et/ENDTIME [c/CATEGORY]... [t/TAG]...`
* `n/` is followed by the event name, it is case-sensitive.
* `sd/` is followed by the starting date, it has to be a **valid date** and in the format of **YYYY-MM-DD**. Here, Y is the year, M is the month, D is the day and all has to be integers.
* `st/` is followed by the time in the 24-hour format and in the format of **hh:mm** Here, h is the hour, m is the minute and all has to be integers.
* `ed/` is followed by the end date, it has to be a **valid date** and in the format of **YYYY-MM-DD**.
* `et/` is followed by the time in the 24-hour format and in the format of **hh:mm**.
* The STARTDATE and STARTTIME provided can be in the past (ongoing event).
* The STARTDATE and STARTTIME provided should be earlier than ENDDATE and ENDTIME.
* The ENDDATE and ENDTIME provided cannot be a past date time.
* Time overlapping events are allowed.
* `c/` is followed by the category. It is optional.
* `t/` is followed by the tag. It is optional.

Examples:
* `add_event n/CS2103 meeting sd/2021-05-27 st/15:00 ed/2022-02-27 et/17:00` adds an event with name `CS2103` and its 
  respective attributes to the event list.

[Return to Feature List](#feature-list)


### Deleting an event: `delete_event`
Deletes an event from the event list.

Format: `delete_event INDEX`
* Deletes the event at the specified INDEX.
* The index refers to the index number shown in the displayed event list.
* The index must be a positive and valid integer 1, 2, 3, ...

Examples:
* `delete_event 3` deletes the third event from the event list.

[Return to Feature List](#feature-list)


### Editing an event: `edit_event`
Edits an **existing and uncompleted** event in the event list.

Format: `edit_event INDEX [n/EVENTNAME] [sd/STARTDATE] [st/STARTTIME] [ed/ENDDATE] [et/ENDTIME] [c/CATEGORY]... [t/TAG]...`
* Edits the event at the specified `INDEX`. The index refers to the index number shown in the displayed event list. The index **must be a positive integer** 1, 2, 3, …​
* You can only edit the details of an unexpired event.
* At least one of the optional fields must be provided.
* The STARTDATE and STARTTIME provided can be in the past (ongoing event).
* The STARTDATE and STARTTIME provided should be earlier than ENDDATE and ENDTIME.
* The ENDDATE and ENDTIME provided cannot be a past date time.
* Existing values will be updated to the input values.
* When editing tags/categories, the existing tags/categories of the event will be removed i.e. adding of tags/categories
  is not cumulative.
* You can remove all the event’s tags by typing `t/` without specifying any tags after it. 
  Similarly, you can remove all the event’s categories by typing `c/` without specifying any categories after it.

Examples:
* `edit_event 1 n/editedEventName` edits the name of the first event (if present in the event list) to be 
  `editedEventName`.
* `edit_event 2 sd/2021-03-18 t/` edits the start date of the second event (if present in the event list) to be 
  `2021-03-18`and clears all existing tags.

[Return to Feature List](#feature-list)


### Listing all events: `list_event`
Lists all events from the event list.

Format: `list_event`

[Return to Feature List](#feature-list)


### Getting today's events: `today_event`
Lists all events whose duration have overlap with today from the event list.

Format: `today_event`

[Return to Feature List](#feature-list)


### Finding events by name: `find_event`
Finds events whose names contain any of the given keywords from the event list.

Format: `find_event KEYWORDS [MORE_KEYWORDS]`
* The search is case-insensitive. e.g. `meeting` will match `Meeting`.
* The order of the keywords does not matter. e.g. `Attending Lecture` will match `Lecture Attending`.
* Only the name of the events is searched.
* Only full words will be matched. e.g. `CS` will not match `CS2103`.
* Events matching at least one keyword will be returned (i.e. `OR` search). e.g. `CS2103 Meeting` will return
  `Project Meeting`, `CS2103 Lecture`.

Examples:
* `find_event Meeting` returns `project meeting` and `Research Meeting`.
* `find_event talk competition` returns `Career Talk`, `Coding Competition`
  ![find_event example](images/find_event-example.png)

[Return to Feature List](#feature-list)


### Clearing expired events: `clear_expired_event`
Clears events with past end date time from the event list.

Format: `clear_expired_event`
* For an event to be considered expired, the event should have past end date time compare to the local time on the user's computer, 
hence changing of timing on a computer could affect the judgement of expiration.
* If there's no expired event in the list (or even no any event in the list), this command is still able to be executed
and return success message `Expired events (if any) have been cleared!` (In this case, no event is cleared since no event is expired.)

#### Illustration of usage of `clear_expired_event`:
![Example of usage of `clear_expired_event`](images/ClearExpiredEventUsage.png)

[Return to Feature List](#feature-list)


### Finding tasks and events before or on a given date: `find_schedule`
Finds uncompleted tasks that are due before or on the specified date 
and events that are ongoing given the specified date.

Format: `find_schedule DATE`
* Tasks to be found here are uncompleted tasks with deadlines before or on the specified date.
* Events to be found here are events with start date before or on the specified date and end date after or on the specified date, 
  i.e., `event start date <= given date <= event end date`.
* Date entered must be a valid date and in the format of `YYYY-MM-DD`, e.g. `2021-04-01`. 
  It can be a date that is earlier than today.
* Only one single date can be entered. 
  If more than one dates are supplied, program will return an error message indicating invalid date format. 
  If no date is given, an error message indicating invalid command format will be returned.
* After running `find_schedule`, if you wish to view all existing tasks and all existing events, 
  please use the `list_task` and `list_event` respectively.

Examples:
* `find_schedule 2021-04-10` finds all existing uncompleted tasks with deadlines before or on the specified date
  and all existing events with start date before or on the specified date and end date after or on 
  before or on the specified date.

#### Illustration of usage of `find_schedule`:

Due to size constraint, this illustration is split into the before and after view for task list and that for event list.

For task list:

![Example of usage of `find schedule(task)`](images/FindScheduleUsageTask.png)

For event list:

![Example of usage of `find schedule(event)`](images/FindScheduleUsageEvent.png)

[Return to Feature List](#feature-list)


### Finding free time slots: `free_time`
Finds all free time slots on the given date from the event list.

Format: `free_time DATE`
* **Free time slots** refer to all times in the given date without any event happening
* Date entered must be a valid date and in the format of `YYYY-MM-DD`, e.g. `2021-04-01`
* Only one single date can be entered. If more than one dates are supplied, program will return an error message
  indicating invalid date.

Examples:
* `free_time 2022-02-01` finds all free time slots on the given date `10th April 2021`.

#### Illustration of usage of `free_time`:
![Example of usage of `free_time`](images/FindFreeTimeExample.png)

[Return to Feature List](#feature-list)

### Summarising tasks and events statistics: `summary`
Displays a summary of tasks completion status and events upcoming in the next 7 days.

Format: `summary`
* **Completed tasks** refer to tasks that are done regardless of when the deadline is.
* **Overdue tasks** refer to tasks that are uncompleted and the current date now has passed the deadline,
  i.e., `completionStatus is INCOMPLETE` and `deadline is before current date`
* **Tasks to be completed before deadline** refer to tasks that are incomplete and the current date now has not passed the deadline,
  i.e., `completionStatus is INCOMPLETE` and `deadline is after current date`
* **Events upcoming in the next 7 days** refer to events that are going to happen in the next 7 days. Events that are happening today are not included.

#### Illustration of usage of `summary`:
![Example of usage of `summary`](images/SummaryExample.png)

[Return to Feature List](#feature-list)


### Clearing Sochedule: `clear`
Clears all tasks and events in the SOChedule's task list and event list.

Format: `clear`

#### Illustration of usage of `clear`:
![Example of usage of `clear`](images/ClearExample.png)

[Return to Feature List](#feature-list)

### Exiting the program: `exit`
Exits the program.

[Return to Feature List](#feature-list)

[Return to Table of Contents](#table-of-contents)

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Download the JAR file onto the other computer and overwrite the empty data file it creates with the file that contains the data of your previous SOChedule home folder (this is contained within the `/data` folder in the same location as your SOChedule.jar.

[Return to Table of Contents](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## Command summary

### General commands

Action | Format, Examples
--------|------------------
**Help** | `help`
**Exit** | `exit`

### Task-related commands

Action | Format, Examples
--------|------------------
**Add** | `add_task n/TASKNAME d/DEADLINE p/PRIORITY [c/CATEGORY]... [t/TAG]...` <br> e.g., `add_task n/CS2103 assignment d/2021-02-27 p/1 c/school work t/urgent`
**Delete** | `delete_task INDEX`<br>e.g., `delete_task 1`
**Done** | `done_task INDEX1 [INDEX2] ...`<br>e.g., `done_task 1 2`
**Undone** | `undone_task INDEX`<br>e.g., `undone_task 1`
**Edit** | `edit_task INDEX [n/TASKNAME] [d/DEADLINE] [p/PRIORITY] [c/CATEGORY]... [t/TAG]...` <br> e.g., `edit_task 1 n/editedTaskName`
**List** | `list_task`
**Today** | `today_task`
**Find** | `find_task KEYWORDS`<br>e.g., `find_task homework`
**Sort** | `sort_task ARGUMENT`<br>e.g., `sort_task name`
**Pin** | `pin_task INDEX`<br>e.g., `pin_task 1`
**Unpin** | `unpin_task INDEX`<br>e.g., `unpin_task 1`
**Clear Completed** | `clear_completed_task`
**Clear Expired** | `clear_expired_task`

### Event-related commands

Action | Format, Examples
--------|------------------
**Add** | `add_event n/TASKNAME sd/STARTDATE st/STARTTIME ed/ENDDATE et/ENDTIME [c/CATEGORY]... [t/TAG]...`<br> e.g., `add_event n/CS2103 meeting sd/2021-02-27 st/15:00 ed/2021-02-27 et/17:00`
**Delete** | `delete_event INDEX`<br>e.g., `delete_event 3`
**List** | `list_event`
**Today** | `today_event`
**Find** | `find_event KEYWORDS`<br>e.g., `find_event meeting`
**Clear Completed** | `clear_expired_event`
**Find Free Time** | `free_time DATE` <br>e.g., `free_time 2021-01-01`

### Commands related to both task and event

Action | Format, Examples
--------|------------------
**Find Schedule** | `find_schedule DATE` <br>e.g., `find_schedule 2021-06-01`
**Clear Schedule** | `clear`
**Summary** | `summary`

[Return to Table of Contents](#table-of-contents)
