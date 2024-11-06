# Kata: "Birthday Greetings"

As you’re a very friendly person, you would like to send a birthday note to all the friends you have. But you have a lot of friends, and a bit lazy, it may take some time to write all the notes by hand.
The good news is that computers can do it automatically for you.


## Friends Data

Imagine you have a flat file with all your friends:

```
last_name, first_name, date_of_birth, email
Doe, John, 1982/10/08, john.doe@foobar.com
Ann, Mary, 1975/09/11, mary.ann@foobar.com
```


And you want to send them a happy birthday email on their birth date:

```
Subject: Happy Birthday!

Happy birthday, dear <first_name>!
```


## Software Implementation

How would this software look like? 

Try to implement it so you can easily change:
- The way you retrieve the friends data (for instance, try switching to a SQLite database).
- The way you send the note (for instance, imagine you want to send SMS instead of emails).
Testing

What kind of tests would you write? Would you use mocks?


Once you finished this feature, read on to get the new features request from management… (scroll down)

### Additional Features
1 Friends born on February 29th should have their birthday greeted on February 28th.
<div style="height: 1000px;"></div>






























2 The input format has changed, now it is not read anymore from a file exported from a database, but we get the information from an API call in a json format. Adjust your code to be able to process also this input format
```
[
    {
        "last_name": "Doe",
        "first_name": "John",
        "date_of_birth": "1982/10/08",
        "email": "john.doe@foobar.com"
    },
    {
        "last_name": "Ann",
        "first_name": "Mary",
        "date_of_birth": "1975/09/11",
        "email": "mary.ann@foobar.com"
    }
]

```

<div style="height: 1000px;"></div>


































3 Provide an interface providing a list of upcoming birthdays for the upcoming month
<div style="height: 1000px;"></div>



































4 Oh shit, some mistake happened. Unfortunately we use DDD (Domain Driven Design) only for the technical part, not for the requirements.. we misunderstood the last feature
-> send a list of upcoming birthdays for the upcoming week
<div style="height: 1000px;"></div>



































5 Send a Birthday Reminder note when it is someone else birthday :
```
Subject: Birthday Reminder

Dear <first_name>,

Today is <someone_else_first_name> <someone_else_last_name>'s birthday.

Don't forget to send him a message!
```
<div style="height: 1000px;"></div>



































6 Send a single Birthday Reminder note
```
Subject: Birthday Reminder

Dear <first_name>,

Today is <full_name_1>, <full_name_2>, and <full_name_3>'s birthday. 

Don't forget to send them a message!
```
