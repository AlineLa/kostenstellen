drop package CmmndExctrFacade;
drop package SubjFacade;
drop package AbsKstnArtFacade;
drop package TrnsktnFacade;
drop package ErzgTrnsktnCMDFacade;
drop package FndKntCMDFacade;
drop package AllgmnKstnFacade;
drop package TrnsFcdTrnsktnsFacade;
drop package SrvrFacade;
drop package TrnsfrFacade;
drop package ErzgKntCMDFacade;
drop package BchKntCMDFacade;
drop package ArtnMngrFacade;
drop package RsKstnFacade;
drop package CmmndCrdntrFacade;
drop package CmmnDtFacade;
drop package KnkrKstnArtFacade;
drop package KstnArtWrzlFacade;
drop package KntFcdFacade;
drop package KntFacade;
drop package TrnsFcdFacade;
drop package LhnKstnFacade;
drop package ManyServices;
drop package ClassFacade;
drop table Cls cascade constraints;
drop table DeletedObjects cascade constraints;
drop sequence SSpecialization;
drop table Specialization cascade constraints;
drop table Association cascade constraints;
drop table Association3 cascade constraints;
drop sequence SCmmndExctr;
drop table CmmndExctr cascade constraints;
drop sequence SSubj;
drop table Subj cascade constraints;
drop sequence SAbsKstnArt;
drop table AbsKstnArt cascade constraints;
drop sequence STrnsktn;
drop table Trnsktn cascade constraints;
drop sequence SErzgTrnsktnCMD;
drop table ErzgTrnsktnCMD cascade constraints;
drop sequence SFndKntCMD;
drop table FndKntCMD cascade constraints;
drop sequence STrnsFcdTrnsktns;
drop table TrnsFcdTrnsktns cascade constraints;
drop sequence SSrvr;
drop table Srvr cascade constraints;
drop sequence STrnsfr;
drop table Trnsfr cascade constraints;
drop sequence SErzgKntCMD;
drop table ErzgKntCMD cascade constraints;
drop sequence SBchKntCMD;
drop table BchKntCMD cascade constraints;
drop sequence SArtnMngr;
drop table ArtnMngr cascade constraints;
drop sequence SCmmndCrdntr;
drop table CmmndCrdntr cascade constraints;
drop sequence SCmmnDt;
drop table CmmnDt cascade constraints;
drop sequence SKnt;
drop table Knt cascade constraints;
drop sequence SKntFcd;
drop table KntFcd cascade constraints;
drop sequence STrnsFcd;
drop table TrnsFcd cascade constraints;
drop sequence SCmmndExctrCommands;
drop table CmmndExctrCommands cascade constraints;
drop sequence SSubjObs;
drop table SubjObs cascade constraints;
drop sequence STrnsktnTrnsfrs;
drop table TrnsktnTrnsfrs cascade constraints;
drop sequence STrnsFcdTrnsktnsObs;
drop table TrnsFcdTrnsktnsObs cascade constraints;
drop sequence SArtnMngrArtn;
drop table ArtnMngrArtn cascade constraints;
drop sequence SCmmndCrdntrExctr;
drop table CmmndCrdntrExctr cascade constraints;
drop sequence SKntFcdKntn;
drop table KntFcdKntn cascade constraints;