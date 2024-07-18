-- TABLE
CREATE TABLE bookings (
    bookingid INT PRIMARY KEY,
    guestid INT,
    eventid INT,
    venueid INT,
    bookingdate DATE,
    bookingstatus VARCHAR(50),
    additionaldetails TEXT,
    FOREIGN KEY (guestid ) REFERENCES guests(guestid),
    FOREIGN KEY (eventid) REFERENCES events(eventid),
    FOREIGN KEY (venueid) REFERENCES venues(venueid)
);
CREATE TABLE demo (ID integer primary key, Name varchar(20), Hint text );
CREATE TABLE events (
    eventid INT PRIMARY KEY,
    etname VARCHAR(100),
    edate DATE,
    etime TIME,
    etype VARCHAR(50),
    numattendees INT
);
CREATE TABLE guests(
    guestid INT PRIMARY KEY,
    guestname VARCHAR(100),
    email VARCHAR(100),
    phonenumber VARCHAR(20)
);
CREATE TABLE payments (
    paymentid INT PRIMARY KEY,
    bookingid INT,
    paymentdate DATE,
    paymentamount DECIMAL(10, 2),
    paymentmethod VARCHAR(50),
    paymentstatus VARCHAR(50),
    FOREIGN KEY (bookingid) REFERENCES bookings(bookingid)
);
CREATE TABLE staff (
    staffid INT PRIMARY KEY,
    staffname VARCHAR(100),
    role VARCHAR(50),
    schedule VARCHAR(100)
);
CREATE TABLE venues (
    venueid INT PRIMARY KEY,
    vname VARCHAR(100),
    capacity INT,
    amenities TEXT,
    pricing DECIMAL(10, 2),
    availability BOOLEAN
);
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 
