create or replace package body ClassFacade is

  procedure insertType(typeId number, className varchar2, concreteVal number) is
  begin
    insert into  Cls (id, name, concrete) values (typeId, className, concreteVal);
  end;

  function getTypeInfos return TypeInfoCollection is
    result TypeInfoCollection;
  begin
	open result for select * from Cls;
	return result;
  end;
  
  procedure insertSpecialization(ancestorVal number, descendantVal number) is
  test number;
  begin
    select id into test from Specialization where ancestor = descendantVal and descendant = ancestorVal;
	raise_application_error(-20000, 'Cyclic specialization');
  exception
    when no_data_found then
	  begin
	    insert into Specialization select SSpecialization.nextVal, a.ancestor, b.descendant
			   					   from Specialization a, Specialization b
								   where a.descendant = ancestorVal and b.ancestor = descendantVal
								   and (a.ancestor, b.descendant)
								     not in (select ancestor, descendant from Specialization);
	  end;
  end;

  procedure insertAssociation(associationId number, associationName varchar2, ownerId number, targetId number, complexityId number) is
  begin
  	insert into Association (id, name, owner, target, complexity) values(associationId, associationName, ownerId, targetId, complexityId);
  end;

  procedure insertAssociation3(associationId number, associationName varchar2, ownerId number, keyId number, targetId number) is
  begin
  	insert into Association3 (id, name, owner, indxx, target) values (associationId, associationName, ownerId, keyId, targetId);
  end;

  function getAssociationInfos return AssociationInfoCollection is
    result AssociationInfoCollection;
  begin
	open result for select * from Association;
	return result;
  end;

  procedure checkConcrete(typeId number) is
  /* throws exception if not */
  concr number;
  begin
    select concrete into concr from Cls where id = typeId;
	if (concr <> concreteRepresentation) then
	  raise_application_error(-20000, 'Type not concrete');
	end if;
  end;

  procedure checkHasAsDescendant(ancestorVal number, descendantVal number) is
  /* throws exception if not */
  test number;
  begin
    select id into test from Specialization where ancestor = ancestorVal and descendant = descendantVal;
  exception
    when no_data_found then raise_application_error(-20000, descendantVal || ' is not a specialization of ' || ancestorVal);
  end;

  procedure checkIfObjectExists(objectId number, classId number) is
  test number;
  /* throws exception if not */
  begin

        if classId = -109 then
            select id into test from CmmndExctr
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 110 then
            select id into test from Subj
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 112 then
            select id into test from Trnsktn
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 113 then
            select id into test from ErzgTrnsktnCMD
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 114 then
            select id into test from FndKntCMD
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 115 then
            select id into test from AbsKstnArt
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 116 then
            select id into test from TrnsFcdTrnsktns
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = -117 then
            select id into test from Srvr
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 118 then
            select id into test from Trnsfr
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 119 then
            select id into test from ErzgKntCMD
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 120 then
            select id into test from BchKntCMD
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 121 then
            select id into test from ArtnMngr
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 122 then
            select id into test from AbsKstnArt
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = -123 then
            select id into test from CmmndCrdntr
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 124 then
            select id into test from CmmnDt
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 128 then
            select id into test from AbsKstnArt
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 127 then
            select id into test from KntFcd
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 126 then
            select id into test from Knt
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 129 then
            select id into test from TrnsFcd
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 130 then
            select id into test from AbsKstnArt
                where id = objectId and Cls = classId;
            return;
        end if;

    raise_application_error(-20000, 'Object does not exist! objectId: ' || objectId || ' classId: ' || classId);
  exception
    when no_data_found then raise_application_error(-20000, 'Object does not exist! objectId: ' || objectId || ' classId: ' || classId);
  end;

  procedure initialize is
  numberOfEntries number;
  begin
    select count(*) into numberOfEntries from Cls;
    if numberOfEntries = 0 then

                insertType(Integer_CN, 'Integer', 1);
                insertType(String_CN, 'String', 1);
                insertType(Date_CN, 'Date', 1);
                insertType(Text_CN, 'Text', 1);
                insertType(Timestamp_CN, 'Timestamp', 1);
                insertType(Fraction_CN, 'Fraction', 1);
                insertType(CmmndExctr_CN, 'CmmndExctr', 1);
                insertType(Subj_CN, 'Subj', 1);
                insertType(AbsKstnArt_CN, 'AbsKstnArt', 0);
                insertType(Trnsktn_CN, 'Trnsktn', 1);
                insertType(ErzgTrnsktnCMD_CN, 'ErzgTrnsktnCMD', 1);
                insertType(FndKntCMD_CN, 'FndKntCMD', 1);
                insertType(AllgmnKstn_CN, 'AllgmnKstn', 1);
                insertType(TrnsFcdTrnsktns_CN, 'TrnsFcdTrnsktns', 1);
                insertType(Srvr_CN, 'Srvr', 1);
                insertType(Trnsfr_CN, 'Trnsfr', 1);
                insertType(ErzgKntCMD_CN, 'ErzgKntCMD', 1);
                insertType(BchKntCMD_CN, 'BchKntCMD', 1);
                insertType(ArtnMngr_CN, 'ArtnMngr', 1);
                insertType(RsKstn_CN, 'RsKstn', 1);
                insertType(CmmndCrdntr_CN, 'CmmndCrdntr', 1);
                insertType(CmmnDt_CN, 'CmmnDt', 1);
                insertType(KnkrKstnArt_CN, 'KnkrKstnArt', 0);
                insertType(KstnArtWrzl_CN, 'KstnArtWrzl', 1);
                insertType(KntFcd_CN, 'KntFcd', 1);
                insertType(Knt_CN, 'Knt', 1);
                insertType(TrnsFcd_CN, 'TrnsFcd', 1);
                insertType(LhnKstn_CN, 'LhnKstn', 1);
                insertType(CMD_CN, 'CMD', 0);
                insertType(Invoker_CN, 'Invoker', 0);
                insertType(TrnsFcdCMD_CN, 'TrnsFcdCMD', 0);
                insertType(TrnsktnCMD_CN, 'TrnsktnCMD', 0);
                insertType(TrnsfrHrrchHIERARCHY_CN, 'TrnsfrHrrchHIERARCHY', 0);
                insertType(Remote_CN, 'Remote', 0);
                insertType(Dcrts_CN, 'Dcrts', 0);
                insertType(SubjInterface_CN, 'SubjInterface', 0);
                insertType(KntFcdCMD_CN, 'KntFcdCMD', 0);
                insertType(Anything_CN, 'Anything', 0);
                insertType(ObsInterface_CN, 'ObsInterface', 0);
                insertAssociation(CmmndExctrCommands_AN, 'CmmndExctrCommands', -109, 105, 1);
                insertAssociation(SubjObs_AN, 'SubjObs', 110, 138, 1);
                insertAssociation(SubjThis_AN, 'SubjThis', 110, 110, 0);
                insertAssociation(AbsKstnArtSbSrvc_AN, 'AbsKstnArtSbSrvc', 111, 136, 0);
                insertAssociation(AbsKstnArtThis_AN, 'AbsKstnArtThis', 111, 111, 0);
                insertAssociation(TrnsktnTrnsfrs_AN, 'TrnsktnTrnsfrs', 112, 118, 1);
                insertAssociation(TrnsktnSbSrvc_AN, 'TrnsktnSbSrvc', 112, 136, 0);
                insertAssociation(TrnsktnThis_AN, 'TrnsktnThis', 112, 112, 0);
                insertAssociation(ErzgTrnsktnCMDKntID_AN, 'ErzgTrnsktnCMDKntID', 113, 2, 0);
                insertAssociation(ErzgTrnsktnCMDInvoker_AN, 'ErzgTrnsktnCMDInvoker', 113, 103, 0);
                insertAssociation(ErzgTrnsktnCMDCReceiver_AN, 'ErzgTrnsktnCMDCReceiver', 113, 129, 0);
                insertAssociation(ErzgTrnsktnCMDMyCmmnDt_AN, 'ErzgTrnsktnCMDMyCmmnDt', 113, 124, 0);
                insertAssociation(FndKntCMDKntID_AN, 'FndKntCMDKntID', 114, 2, 0);
                insertAssociation(FndKntCMDInvoker_AN, 'FndKntCMDInvoker', 114, 103, 0);
                insertAssociation(FndKntCMDCReceiver_AN, 'FndKntCMDCReceiver', 114, 127, 0);
                insertAssociation(FndKntCMDMyCmmnDt_AN, 'FndKntCMDMyCmmnDt', 114, 124, 0);
                insertAssociation(TrnsFcdTrnsktnsMstr_AN, 'TrnsFcdTrnsktnsMstr', 116, 129, 0);
                insertAssociation(TrnsFcdTrnsktnsObs_AN, 'TrnsFcdTrnsktnsObs', 116, 112, 1);
                insertAssociation(TrnsFcdTrnsktnsThis_AN, 'TrnsFcdTrnsktnsThis', 116, 116, 0);
                insertAssociation(SrvrArtn_AN, 'SrvrArtn', -117, 121, 0);
                insertAssociation(SrvrMngr_AN, 'SrvrMngr', -117, 127, 0);
                insertAssociation(SrvrTrnsktnMngr_AN, 'SrvrTrnsktnMngr', -117, 129, 0);
                insertAssociation(SrvrSbSrvc_AN, 'SrvrSbSrvc', -117, 136, 0);
                insertAssociation(SrvrThis_AN, 'SrvrThis', -117, -117, 0);
                insertAssociation(SrvrPassword_AN, 'SrvrPassword', -117, 2, 0);
                insertAssociation(SrvrUser_AN, 'SrvrUser', -117, 2, 0);
                insertAssociation(SrvrHackCount_AN, 'SrvrHackCount', -117, 1, 0);
                insertAssociation(SrvrHackDelay_AN, 'SrvrHackDelay', -117, 5, 0);
                insertAssociation(TrnsfrVnKnt_AN, 'TrnsfrVnKnt', 118, 126, 0);
                insertAssociation(TrnsfrZKnt_AN, 'TrnsfrZKnt', 118, 126, 0);
                insertAssociation(TrnsfrSmm_AN, 'TrnsfrSmm', 118, 1, 0);
                insertAssociation(TrnsfrKntID_AN, 'TrnsfrKntID', 118, 2, 0);
                insertAssociation(TrnsfrSbSrvc_AN, 'TrnsfrSbSrvc', 118, 136, 0);
                insertAssociation(TrnsfrThis_AN, 'TrnsfrThis', 118, 118, 0);
                insertAssociation(ErzgKntCMDKntID_AN, 'ErzgKntCMDKntID', 119, 2, 0);
                insertAssociation(ErzgKntCMDKntstnd_AN, 'ErzgKntCMDKntstnd', 119, 1, 0);
                insertAssociation(ErzgKntCMDMnmm_AN, 'ErzgKntCMDMnmm', 119, 1, 0);
                insertAssociation(ErzgKntCMDGrnzwrt_AN, 'ErzgKntCMDGrnzwrt', 119, 1, 0);
                insertAssociation(ErzgKntCMDInvoker_AN, 'ErzgKntCMDInvoker', 119, 103, 0);
                insertAssociation(ErzgKntCMDCReceiver_AN, 'ErzgKntCMDCReceiver', 119, 127, 0);
                insertAssociation(ErzgKntCMDMyCmmnDt_AN, 'ErzgKntCMDMyCmmnDt', 119, 124, 0);
                insertAssociation(BchKntCMDInvoker_AN, 'BchKntCMDInvoker', 120, 103, 0);
                insertAssociation(BchKntCMDCReceiver_AN, 'BchKntCMDCReceiver', 120, 112, 0);
                insertAssociation(BchKntCMDMyCmmnDt_AN, 'BchKntCMDMyCmmnDt', 120, 124, 0);
                insertAssociation(ArtnMngrArtn_AN, 'ArtnMngrArtn', 121, 125, 1);
                insertAssociation(ArtnMngrSbSrvc_AN, 'ArtnMngrSbSrvc', 121, 136, 0);
                insertAssociation(ArtnMngrThis_AN, 'ArtnMngrThis', 121, 121, 0);
                insertAssociation(CmmndCrdntrExctr_AN, 'CmmndCrdntrExctr', -123, -109, 1);
                insertAssociation(CmmnDtCrtdt_AN, 'CmmnDtCrtdt', 124, 3, 0);
                insertAssociation(CmmnDtCmmtdt_AN, 'CmmnDtCmmtdt', 124, 3, 0);
                insertAssociation(KnkrKstnArtSpzllrAls_AN, 'KnkrKstnArtSpzllrAls', 125, 111, 0);
                insertAssociation(KntFcdKntn_AN, 'KntFcdKntn', 127, 126, 1);
                insertAssociation(KntFcdSbSrvc_AN, 'KntFcdSbSrvc', 127, 136, 0);
                insertAssociation(KntFcdThis_AN, 'KntFcdThis', 127, 127, 0);
                insertAssociation(KntKntID_AN, 'KntKntID', 126, 2, 0);
                insertAssociation(KntGrnzwrt_AN, 'KntGrnzwrt', 126, 1, 0);
                insertAssociation(KntKntstnd_AN, 'KntKntstnd', 126, 1, 0);
                insertAssociation(KntMnmm_AN, 'KntMnmm', 126, 1, 0);
                insertAssociation(KntSbSrvc_AN, 'KntSbSrvc', 126, 136, 0);
                insertAssociation(KntThis_AN, 'KntThis', 126, 126, 0);
                insertAssociation(TrnsFcdTrnsktns_AN, 'TrnsFcdTrnsktns', 129, 116, 0);
                insertAssociation(TrnsFcdSbSrvc_AN, 'TrnsFcdSbSrvc', 129, 136, 0);
                insertAssociation(TrnsFcdThis_AN, 'TrnsFcdThis', 129, 129, 0);

    end if;
    select count(*) into numberOfEntries from Specialization;
    if numberOfEntries = 0 then

                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 1, 1);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 2, 2);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 3, 3);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 5, 5);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 4, 4);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 6, 6);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, -109, -109);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 110, 110);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 111, 111);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 112, 112);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 113, 113);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 114, 114);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 115, 115);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 116, 116);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, -117, -117);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 118, 118);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 119, 119);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 120, 120);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 121, 121);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 122, 122);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, -123, -123);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 124, 124);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 125, 125);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 128, 128);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 127, 127);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 126, 126);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 129, 129);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 130, 130);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 105, 105);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 103, 103);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 131, 131);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 132, 132);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 134, 134);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 135, 135);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 102, 102);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 136, 136);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 137, 137);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 104, 104);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 138, 138);
                insertSpecialization(Anything_CN, CmmndExctr_CN);
                insertSpecialization(SubjInterface_CN, Subj_CN);
                insertSpecialization(Anything_CN, Subj_CN);
                insertSpecialization(SubjInterface_CN, AbsKstnArt_CN);
                insertSpecialization(Anything_CN, AbsKstnArt_CN);
                insertSpecialization(SubjInterface_CN, Trnsktn_CN);
                insertSpecialization(Anything_CN, Trnsktn_CN);
                insertSpecialization(CmmnDt_CN, ErzgTrnsktnCMD_CN);
                insertSpecialization(TrnsFcdCMD_CN, ErzgTrnsktnCMD_CN);
                insertSpecialization(Anything_CN, ErzgTrnsktnCMD_CN);
                insertSpecialization(CmmnDt_CN, FndKntCMD_CN);
                insertSpecialization(KntFcdCMD_CN, FndKntCMD_CN);
                insertSpecialization(Anything_CN, FndKntCMD_CN);
                insertSpecialization(KnkrKstnArt_CN, AllgmnKstn_CN);
                insertSpecialization(Anything_CN, TrnsFcdTrnsktns_CN);
                insertSpecialization(ObsInterface_CN, TrnsFcdTrnsktns_CN);
                insertSpecialization(Invoker_CN, Srvr_CN);
                insertSpecialization(Remote_CN, Srvr_CN);
                insertSpecialization(SubjInterface_CN, Srvr_CN);
                insertSpecialization(Anything_CN, Srvr_CN);
                insertSpecialization(SubjInterface_CN, Trnsfr_CN);
                insertSpecialization(Anything_CN, Trnsfr_CN);
                insertSpecialization(CmmnDt_CN, ErzgKntCMD_CN);
                insertSpecialization(KntFcdCMD_CN, ErzgKntCMD_CN);
                insertSpecialization(Anything_CN, ErzgKntCMD_CN);
                insertSpecialization(CmmnDt_CN, BchKntCMD_CN);
                insertSpecialization(TrnsktnCMD_CN, BchKntCMD_CN);
                insertSpecialization(Anything_CN, BchKntCMD_CN);
                insertSpecialization(SubjInterface_CN, ArtnMngr_CN);
                insertSpecialization(Anything_CN, ArtnMngr_CN);
                insertSpecialization(KnkrKstnArt_CN, RsKstn_CN);
                insertSpecialization(Anything_CN, CmmndCrdntr_CN);
                insertSpecialization(Anything_CN, CmmnDt_CN);
                insertSpecialization(AbsKstnArt_CN, KnkrKstnArt_CN);
                insertSpecialization(AbsKstnArt_CN, KstnArtWrzl_CN);
                insertSpecialization(SubjInterface_CN, KntFcd_CN);
                insertSpecialization(Anything_CN, KntFcd_CN);
                insertSpecialization(SubjInterface_CN, Knt_CN);
                insertSpecialization(Anything_CN, Knt_CN);
                insertSpecialization(SubjInterface_CN, TrnsFcd_CN);
                insertSpecialization(Anything_CN, TrnsFcd_CN);
                insertSpecialization(KnkrKstnArt_CN, LhnKstn_CN);
                insertSpecialization(CMD_CN, TrnsFcdCMD_CN);
                insertSpecialization(CMD_CN, TrnsktnCMD_CN);
                insertSpecialization(SubjInterface_CN, Dcrts_CN);
                insertSpecialization(CMD_CN, KntFcdCMD_CN);

    end if;
  end;

  procedure deleteObject(objectId number, classId number) is
    oldObjectId number;
    oldClassId number;
  begin
    select id,instanceof into oldObjectId,oldClassId from DeletedObjects where id = objectId and instanceOf = classId;
  exception
    when no_data_found then
      begin
        insert into DeletedObjects (id, instanceOf) values (objectId,classId);
      end;
  end;

end;
/
