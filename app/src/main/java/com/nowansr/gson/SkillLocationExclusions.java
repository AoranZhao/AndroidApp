package com.nowansr.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * Set field or class exclusions to be handled by gson.
 * This class excludes skill and location to be de/serialized by gson because
 * the nowansr /api/skills does not return a full object of Skill or Location.
 */
public class SkillLocationExclusions implements ExclusionStrategy{
    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        if(f.getName().equalsIgnoreCase("location")) {
            return true;
        }
        if(f.getName().equalsIgnoreCase("skills")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
