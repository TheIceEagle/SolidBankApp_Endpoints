CREATE TABLE Account
(
    account_id NVARCHAR(MAX)  NOT NULL,
    account_type NVARCHAR(MAX)  NOT NULL,
    client_id INTEGER  NOT NULL,
    balance FLOAT  NOT NULL,
    withdraw_allowed BIT  NOT NULL,
    CONSTRAINT PK_Account PRIMARY KEY  (account_id)
);

CREATE TABLE Transaction
(
    id INTEGER NOT NULL AUTO_INCREMENT,
    account_id NVARCHAR(MAX) NOT NULL ,
    amount FLOAT  NOT NULL,
    type NVARCHAR(MAX)  NOT NULL,
    CONSTRAINT PK_Transaction PRIMARY KEY  (id),
    FOREIGN KEY (account_id) REFERENCES Account(account_id)
);