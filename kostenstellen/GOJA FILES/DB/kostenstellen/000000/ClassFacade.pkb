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
                insertType(Dcrts_CN, 'Dcrts', 0);
                insertType(Invoker_CN, 'Invoker', 0);
                insertType(Anything_CN, 'Anything', 0);
                insertType(CMD_CN, 'CMD', 0);

    end if;
    select count(*) into numberOfEntries from Specialization;
    if numberOfEntries = 0 then

                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 1, 1);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 2, 2);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 3, 3);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 5, 5);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 4, 4);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 6, 6);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 102, 102);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 103, 103);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 104, 104);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 105, 105);

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
