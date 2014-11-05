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
    Dcrts_CN constant number := 102;
    Invoker_CN constant number := 103;
    Anything_CN constant number := 104;
    CMD_CN constant number := 105;

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
