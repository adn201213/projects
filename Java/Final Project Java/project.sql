Create Table storeProduct(
serialNumber varchar2(20)CONSTRAINT product_id_pk PRIMARY key,
productName VARCHAR2(50),
producingDate Date,
purchaseDate Date default sysdate not null,
cost number(10,2)not null,
retail number(10,2)not null,
quantity number(10,2)not null,
aisle VARCHAR2(10),
category VARCHAR2(10),
comments  VARCHAR2(200)
)

Create Table storeOrder(
orderId number(10)CONSTRAINT storeOrder_pk PRIMARY key,
orderDate Date,
comments VARCHAR2(100) 
)
Create Table storeOrderItem(
orderId number(10) CONSTRAINT storeOrderItem_orderId_fk REFERENCES storeOrder(orderId) not null ,
itemId number(10) not null,
serialNumber varchar2(20) CONSTRAINT storeOrderItem_serialNumber_fk REFERENCES storeProduct(serialNumber) NOT null,
quantity number(10)not NULL
)
Create Table storeInvoice(
invoiceID number(10)CONSTRAINT storeInvoice_pk PRIMARY key,
invoiceDate Date,
invoicePrice number(20,2),
invoiceTax number(20,2),
totalInvoicPrice number(20,2)
)
Create Table StoreinvoiceDetails(
invoiceID number(10)CONSTRAINT StoreinvoiceDetails_invoiceID_fk REFERENCES storeInvoice(invoiceID) NOT null,
serialNumber varchar2(20) CONSTRAINT StoreinvoiceDetails_serialNumber_fk REFERENCES storeProduct(serialNumber) NOT null,
unitPrice number(10,2),
quantity number(10)not NULL,
discount number(10,2),
totalitemTax number(10,2),
TotalItemPrice number(20,2)
)
 