create or replace package ClassFacade is
  
	abstractRepresentation constant number := 0;
  	concreteRepresentation constant number := 1;

	oneRepresentation constant number := 0;
  	manyRepresentation constant number := 1;

	type ObjectInfo is record(
		objectId number,
		classId number
	);
		
	type ObjectInfoCollection is ref cursor return ObjectInfo;

	type ObjectThisInfo is record(
		objectId number,
		classId number,
		thisId number,
		thisClassId number
	);
		
	type ObjectThisInfoCollection is ref cursor return ObjectThisInfo;

	type TypeInfo is record(
		typeId number,
		typeName varchar2(2000),
		abstractInfo number
	);
	
	type TypeInfoCollection is ref cursor return TypeInfo;
	
	type AssociationInfo is record(
		associationId number,
		ownerId number,
		associationName varchar2(2000),
		targetId number,
		complexityInfo number
	);
	
	type AssociationInfoCollection is ref cursor return AssociationInfo;

    Integer_CN constant number := 1;
    String_CN constant number := 2;
    Date_CN constant number := 3;
    Text_CN constant number := 4;
    Timestamp_CN constant number := 5;
    Fraction_CN constant number := 6;
    CmmndExctr_CN constant number := -109;
        CmmndExctrCommands_AN constant number := 10003;
    Subj_CN constant number := 110;
        SubjObs_AN constant number := 10004;
        SubjThis_AN constant number := 10005;
    AbsKstnArt_CN constant number := 111;
        AbsKstnArtSbSrvc_AN constant number := 10006;
        AbsKstnArtThis_AN constant number := 10007;
    Trnsktn_CN constant number := 112;
        TrnsktnTrnsfrs_AN constant number := 10008;
        TrnsktnSbSrvc_AN constant number := 10009;
        TrnsktnThis_AN constant number := 10010;
    ErzgTrnsktnCMD_CN constant number := 113;
        ErzgTrnsktnCMDKntID_AN constant number := 10011;
        ErzgTrnsktnCMDInvoker_AN constant number := 10012;
        ErzgTrnsktnCMDCReceiver_AN constant number := 10013;
        ErzgTrnsktnCMDMyCmmnDt_AN constant number := 10014;
    FndKntCMD_CN constant number := 114;
        FndKntCMDKntID_AN constant number := 10015;
        FndKntCMDInvoker_AN constant number := 10016;
        FndKntCMDCReceiver_AN constant number := 10017;
        FndKntCMDMyCmmnDt_AN constant number := 10018;
    AllgmnKstn_CN constant number := 115;
    TrnsFcdTrnsktns_CN constant number := 116;
        TrnsFcdTrnsktnsMstr_AN constant number := 10020;
        TrnsFcdTrnsktnsObs_AN constant number := 10021;
        TrnsFcdTrnsktnsThis_AN constant number := 10022;
    Srvr_CN constant number := -117;
        SrvrArtn_AN constant number := 10023;
        SrvrMngr_AN constant number := 10024;
        SrvrTrnsktnMngr_AN constant number := 10025;
        SrvrSbSrvc_AN constant number := 10026;
        SrvrThis_AN constant number := 10027;
        SrvrPassword_AN constant number := 10029;
        SrvrUser_AN constant number := 10030;
        SrvrHackCount_AN constant number := 10031;
        SrvrHackDelay_AN constant number := 10032;
    Trnsfr_CN constant number := 118;
        TrnsfrVnKnt_AN constant number := 10033;
        TrnsfrZKnt_AN constant number := 10034;
        TrnsfrSmm_AN constant number := 10035;
        TrnsfrKntID_AN constant number := 10036;
        TrnsfrSbSrvc_AN constant number := 10037;
        TrnsfrThis_AN constant number := 10038;
    ErzgKntCMD_CN constant number := 119;
        ErzgKntCMDKntID_AN constant number := 10039;
        ErzgKntCMDKntstnd_AN constant number := 10040;
        ErzgKntCMDMnmm_AN constant number := 10041;
        ErzgKntCMDGrnzwrt_AN constant number := 10042;
        ErzgKntCMDInvoker_AN constant number := 10043;
        ErzgKntCMDCReceiver_AN constant number := 10044;
        ErzgKntCMDMyCmmnDt_AN constant number := 10045;
    BchKntCMD_CN constant number := 120;
        BchKntCMDInvoker_AN constant number := 10046;
        BchKntCMDCReceiver_AN constant number := 10047;
        BchKntCMDMyCmmnDt_AN constant number := 10048;
    ArtnMngr_CN constant number := 121;
        ArtnMngrArtn_AN constant number := 10049;
        ArtnMngrSbSrvc_AN constant number := 10050;
        ArtnMngrThis_AN constant number := 10051;
    RsKstn_CN constant number := 122;
    CmmndCrdntr_CN constant number := -123;
        CmmndCrdntrExctr_AN constant number := 10052;
    CmmnDt_CN constant number := 124;
        CmmnDtCrtdt_AN constant number := 10053;
        CmmnDtCmmtdt_AN constant number := 10054;
    KnkrKstnArt_CN constant number := 125;
        KnkrKstnArtSpzllrAls_AN constant number := 10055;
    KstnArtWrzl_CN constant number := 128;
    KntFcd_CN constant number := 127;
        KntFcdKntn_AN constant number := 10062;
        KntFcdSbSrvc_AN constant number := 10063;
        KntFcdThis_AN constant number := 10064;
    Knt_CN constant number := 126;
        KntKntID_AN constant number := 10056;
        KntGrnzwrt_AN constant number := 10057;
        KntKntstnd_AN constant number := 10058;
        KntMnmm_AN constant number := 10059;
        KntSbSrvc_AN constant number := 10060;
        KntThis_AN constant number := 10061;
    TrnsFcd_CN constant number := 129;
        TrnsFcdTrnsktns_AN constant number := 10065;
        TrnsFcdSbSrvc_AN constant number := 10066;
        TrnsFcdThis_AN constant number := 10067;
    LhnKstn_CN constant number := 130;
    CMD_CN constant number := 105;
    Invoker_CN constant number := 103;
    TrnsFcdCMD_CN constant number := 131;
    TrnsktnCMD_CN constant number := 132;
    TrnsfrHrrchHIERARCHY_CN constant number := 134;
    Remote_CN constant number := 135;
    Dcrts_CN constant number := 102;
    SubjInterface_CN constant number := 136;
    KntFcdCMD_CN constant number := 137;
    Anything_CN constant number := 104;
    ObsInterface_CN constant number := 138;

  	procedure insertType(typeId number, className varchar2, concreteVal number);
  	function getTypeInfos return TypeInfoCollection;
  	procedure insertSpecialization(ancestorVal number, descendantVal number);
  	procedure insertAssociation(associationId number, associationName varchar2, ownerId number, targetId number, complexityId number);
  	procedure insertAssociation3(associationId number, associationName varchar2, ownerId number, keyId number, targetId number);
  	function getAssociationInfos return AssociationInfoCollection;
  	procedure checkConcrete(typeId number);
  	/* throws exception if not */
  	procedure checkHasAsDescendant(ancestorVal number, descendantVal number);
  	/* throws exception if not */
  	procedure checkIfObjectExists(objectId number, classId number);
  	/* throws exception if not */
	procedure initialize;
	procedure deleteObject(objectId number, classId number);
end;
/
