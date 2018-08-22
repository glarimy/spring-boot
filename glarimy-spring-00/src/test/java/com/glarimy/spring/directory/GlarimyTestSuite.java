package com.glarimy.spring.directory;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.glarimy.spring.directory.data.GlarimyEmployeeRepositoryTest;
import com.glarimy.spring.directory.service.GlarimyDirectoryTest;

@RunWith(Suite.class)
@SuiteClasses({ GlarimyDirectoryTest.class, GlarimyEmployeeRepositoryTest.class })
public class GlarimyTestSuite {

}
