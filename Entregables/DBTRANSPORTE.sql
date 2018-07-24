

Create database DBTRANSPORTE
GO
Use DBTRANSPORTE
GO

CREATE TABLE BUS (
    COD_BUS int  IDENTITY (1,1) PRIMARY KEY,
    RUT_BUS varchar(100) NULL  ,
    PLAC_BUS char(15)   NULL ,
    ASIENT_BUS INT    NULL,
    SUCURSAL_COD_SUCUR int,

);

-- Table: EMPRESA
CREATE TABLE EMPRESA (
    COD_EMP int  IDENTITY (1,1) PRIMARY KEY
);

-- Table: PASAJERO
CREATE TABLE PASAJERO (
    COD_PAS int  IDENTITY (1,1) PRIMARY KEY,
    NOM_PAS varchar(100) null ,
    APE_PAS varchar(100)  null,
    TIPDOC_PAS char(11)   null,
    DEST_PAS varchar(100) null,
    FECVIAJ_PAS date null ,
    RAZSOC_PAS varchar(100) null ,
    EDAD_PAS char(2) null  ,
    BUS_COD_BUS int 

);

-- Table: SUCURSAL
CREATE TABLE SUCURSAL (
    COD_SUCUR int IDENTITY (1,1) PRIMARY KEY,
    ORIG_SUCUR varchar(100)  null ,
    EMPRESA_COD_EMP int
);

-- foreign keys
-- Reference: BUS_SUCURSAL (table: BUS)
ALTER TABLE BUS ADD CONSTRAINT BUS_SUCURSAL
    FOREIGN KEY (SUCURSAL_COD_SUCUR)
    REFERENCES SUCURSAL (COD_SUCUR);

-- Reference: PASAJERO_BUS (table: PASAJERO)
ALTER TABLE PASAJERO ADD CONSTRAINT PASAJERO_BUS
    FOREIGN KEY (BUS_COD_BUS)
    REFERENCES BUS (COD_BUS);

-- Reference: SUCURSAL_EMPRESA (table: SUCURSAL)
ALTER TABLE SUCURSAL ADD CONSTRAINT SUCURSAL_EMPRESA
    FOREIGN KEY (EMPRESA_COD_EMP)
    REFERENCES EMPRESA (COD_EMP);



	Create procedure ListBus 
	as
	begin
	select * from Bus
	end 
	go

	Exec ListBus

	Create Procedure InsertBus
	@RUT_BUS VARCHAR(100),
	@PLAC_BUS CHAR(15),
	@ASIENT_BUS INT
	AS 
	BEGIN
	insert into BUS (RUT_BUS, PLAC_BUS, ASIENT_BUS) values (@RUT_BUS ,@PLAC_BUS, @ASIENT_BUS)
    END
	GO

	EXEC InsertBus @RUT_BUS='ICA-CA�ETE', @PLAC_BUS='FBVC4567891123A', @ASIENT_BUS='50'
	EXEC InsertBus @RUT_BUS='LIMA-CA�ETE', @PLAC_BUS='FBVCQ67891123A', @ASIENT_BUS='50'
	EXEC InsertBus @RUT_BUS='CA�ETE-CHINCHA', @PLAC_BUS='FBVCAF67891123A', @ASIENT_BUS='50'
	EXEC InsertBus @RUT_BUS='ICA-CHICNHA', @PLAC_BUS='FBVCR567891123A', @ASIENT_BUS='50'
	EXEC InsertBus @RUT_BUS='CHICNHA-CA�ETE', @PLAC_BUS='FBVCP567891123A', @ASIENT_BUS='50'


	CREATE PROCEDURE DELETEBUS
    @COD_BUS INT
	AS
	BEGIN
	DELETE FROM BUS WHERE COD_BUS = @COD_BUS
	END
	GO


	EXEC DELETEBUS @COD_BUS='2'


	CREATE PROCEDURE UPDATEBUS
	@COD_BUS INT,
	@RUT_BUS VARCHAR(100),
	@PLAC_BUS CHAR(15),
	@ASIENT_BUS INT 
	AS 
	BEGIN
	UPDATE BUS SET  RUT_BUS=@RUT_BUS, PLAC_BUS=@PLAC_BUS, ASIENT_BUS=@ASIENT_BUS WHERE COD_BUS=@COD_BUS
	END
	GO
	
	EXEC UPDATEBUS @RUT_BUS='CHINCHA_CA�ETE', @PLAC_BUS='FKL6541231478AS'  ,@ASIENT_BUS='55',@COD_BUS='1'








