CREATE OR REPLACE PROCEDURE InsertBook(
myBookID IN NUMBER,
myBookName IN VARCHAR2,
myPublisher IN VARCHAR2,
myPrice IN NUMBER)
AS
BEGIN
INSERT INTO Book(bookid, bookname, publisher, price)
VALUES(myBookID, myBookName, myPublisher, myPrice);
END;


EXEC InsertBook(13, '스포츠과학', '마당과서적', 25000);
SELECT * FROM Book;



CREATE OR REPLACE PROCEDURE BookInsertOrUpdate(
    myBookID NUMBER,
    myBookName VARCHAR2,
    myPublisher VARCHAR2,
    myPrice INT)
AS
    mycount NUMBER;
BEGIN
    SELECT count(*) INTO mycount FROM Book
    WHERE bookname LIKE myBookName;
    IF mycount !=0 THEN
    UPDATE Book SET price = myPrice
    WHERE bookname LIKE myBookName;

    ELSE
    INSERT INTO Book(bookid, bookname, publisher, price)
    VALUES(myBookID, myBookName, myPublisher, myPrice);
    END IF;
END;



EXEC bookinsertorupdate(15, '스포츠 즐거움', '마당과학서적', 25000);
SELECT * FROM Book;