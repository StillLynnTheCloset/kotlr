package com.highthunder.kotlr

import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses

@RunWith(Suite::class)
@SuiteClasses(ParseNpfIntegrationTest::class)
class IntegrationSuite

@RunWith(Suite::class)
@SuiteClasses(ParseNpfUnitTest::class)
class UnitSuite

@RunWith(Suite::class)
@SuiteClasses(ParseNpfUnitTest::class, ParseNpfIntegrationTest::class, ParseResponseTest::class, TumblrTest::class)
class ParsingSuite
