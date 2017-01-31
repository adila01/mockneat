package com.mockneat.sources.random;

import com.mockneat.sources.random.unit.*;
import com.mockneat.types.enums.RandType;

import java.util.*;

public class Rand {

    private Random random;

    private Chars rChars;
    private Bools rBools;
    private Bytes rBytes;
    private Countries rCountries;
    private CCS rCCS;
    private CVVS rCVVS;
    private CharsDigits rDigits;
    private Dicts rDicts;
    private Doubles rDoubles;
    private Emails rEmails;
    private Floats rFloats;
    private Ints rInts;
    private IPv4s rIPv4s;
    private Longs rLongs;
    private Macs rMacs;
    private Names rNames;
    private Objs rObjects;
    private Users rUsers;

    public Rand(RandType randomType) {
        this.random = randomType.getRandom();

        this.rChars = new Chars(this);
        this.rBools = new Bools(this);
        this.rBytes = new Bytes(this);
        this.rCountries = new Countries(this);
        this.rCCS = new CCS(this);
        this.rCVVS = new CVVS(this);
        this.rDicts = new Dicts(this);
        this.rDoubles = new Doubles(this);
        this.rEmails = new Emails(this);
        this.rFloats = new Floats(this);
        this.rDigits = new CharsDigits(this);
        this.rInts = new Ints(this);
        this.rIPv4s = new IPv4s(this);
        this.rLongs = new Longs(this);
        this.rMacs = new Macs(this);
        this.rNames = new Names(this);
        this.rObjects = new Objs(this);
        this.rUsers = new Users(this);

    }

    public Rand() {
        this(RandType.THREAD_LOCAL_RANDOM);
    }

    public Rand(RandType randomType, Long seed) {
        this(randomType);
        random.setSeed(seed);
    }

    public Chars chars() {
        return this.rChars;
    }


    public Bools bools() {
        return this.rBools;
    }

    public Bytes bytes() {
        return this.rBytes;
    }

    public Countries countries() {
        return this.rCountries;
    }

    public CCS ccs() {
        return this.rCCS;
    }

    public CVVS cvvs() { return this.rCVVS; }

    public Dicts dicts() {
        return this.rDicts;
    }

    public CharsDigits digits() { return this.rDigits; }

    public Doubles doubles() {
        return this.rDoubles;
    }

    public Emails emails() { return this.rEmails; }

    public Floats floats() { return this.rFloats; }

    public Ints ints() { return this.rInts; }

    public IPv4s ipv4s() { return this.rIPv4s; }

    public Longs longs() { return this.rLongs; }

    public Macs macs() { return this.rMacs; }

    public Names names() { return this.rNames; }

    public Objs objs() { return this.rObjects; }

    public Users users() { return this.rUsers; }

    public Random getRandom() {
        return random;
    }

}
