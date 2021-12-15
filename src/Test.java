import javax.management.Notification;
import java.time.LocalDate;
import java.util.LinkedList;

public class Test {

    public static void main(String[] args) {
//        ----------------------------------------Companies, Managers & Departments-------------------------------------
        Manager SundarPichai = new Manager();
        Manager JeffBezos = new Manager();

        Company Google = new Company("Google", SundarPichai);
        Company Amazon = new Company("Amazon", JeffBezos);
        Company JPMorgan = new Company("JP Morgan");
        Company GoldmanSachs = new Company("Goldman Sachs");
        Company Softwire = new Company("Softwire");
        Company Bloomberg = new Company("Bloomberg");
        Company Microsoft = new Company("Microsoft");
        Company MIT = new Company("MIT");
        Company NXP = new Company("NXP");

        Department itGoogle = DepartmentFactory.factory("IT");
        Department itAmazon = DepartmentFactory.factory("IT");


        Department managementGoogle = DepartmentFactory.factory("Management");
        Department managementAmazon = DepartmentFactory.factory("Management");

        Department marketingGoogle = DepartmentFactory.factory("Marketing");
        Department marketingAmazon = DepartmentFactory.factory("Marketing");

        Department financeGoogle = DepartmentFactory.factory("Finance");
        Department financeAmazon = DepartmentFactory.factory("Finance");

        Google.add(itGoogle);
        Google.add(managementGoogle);
        Google.add(marketingGoogle);
        Google.add(financeGoogle);

        Amazon.add(itAmazon);
        Amazon.add(marketingAmazon);
        Amazon.add(managementAmazon);
        Amazon.add(financeAmazon);

//        ----------------------------------------(E1) Harmony Lorinda--------------------------------------------------

        Information harmonyLorinda = new Information("Harmony", "Lorinda", "Female",
                "harmonyl@gmail.com", "+4111111111", LocalDate.of(1986, 1, 12));
        harmonyLorinda.addLanguage("English", "Experienced");
        harmonyLorinda.addLanguage("French", "Beginner");
        Resume resumeE1HarmonyLorinda = new Resume();
        try {
            Education eduHarmonyLorinda1 = new Education("Thomas Jefferson High School for Science and Technology",
                    2000, 8, 1, 2004, 6, 1, "highschool", 9.75);
            Education eduHarmonyLorinda2 = new Education("MIT", 2004, 8, 1,
                    2008, 6, 1, "college", 9.0);
            Experience expHarmonyLorinda1 = new Experience(Google, "SDE", "IT", 2006,
                    7, 1, 2010, 4, 1);
            Experience expHarmonyLorinda2 = new Experience(Amazon, "Senior SDE","IT", 2010,
                    5, 1);

            try {
                resumeE1HarmonyLorinda = new Resume.ResumeBuilder()
                        .information(harmonyLorinda)
                        .addEduBackgnd(eduHarmonyLorinda1)
                        .addEduBackgnd(eduHarmonyLorinda2)
                        .addExpBackgnd(expHarmonyLorinda1)
                        .addExpBackgnd(expHarmonyLorinda2)
                        .build();
            } catch (ResumeIncompleteException e) {
                e.printStackTrace();
            }
        } catch(InvalidDatesException e) {
            e.printStackTrace();
        }

//        ----------------------------------------(E2) Shana Addy--------------------------------------------------

        Information shanaAddy = new Information("Shana", "Addy", "Male", "shanad@gmail.com",
                "+4111111112", LocalDate.of(1995, 4, 20));

        Resume resumeE2ShanaAddy = new Resume();
        try {
            Education edu1 = new Education("Heiderlberg American High School", 2010, 8, 1,
                    2014, 6, 1, "highschool", 8.87);
            Education edu2 = new Education("University of Munich", 2014, 8, 1,
                    2018, 6, 1, "college", 9.65);

            Experience exp1 = new Experience(Amazon, "Manager","Management", 2010, 5, 1);

            try {
                resumeE2ShanaAddy = new Resume.ResumeBuilder()
                        .information(shanaAddy)
                        .addEduBackgnd(edu1)
                        .addEduBackgnd(edu2)
                        .addExpBackgnd(exp1)
                        .build();
            } catch (ResumeIncompleteException e) {
                e.printStackTrace();
            }
        } catch(InvalidDatesException e) {
            e.printStackTrace();
        }

//        ----------------------------------------(E3) Leyla Stacy--------------------------------------------------
        Information leylaStacy = new Information("Leyla", "Stacy", "Female", "leylasd@gmail.com",
                "+4111111113", LocalDate.of(1994, 11, 27));

        Resume resumeE3LeylaStacy = new Resume();
        try {
            Education edu1 = new Education("Kings High School", 2015, 8, 1,
                    2019, 6, 1, "highschool", 8.87);
            Education edu2 = new Education("Kings's College", 2019, 10, 1,
                    "college", 9.89);

            Experience exp1 = new Experience(Amazon, "Marketing Intern","Marketing", 2010,
                    5, 1);

            try {
                resumeE3LeylaStacy = new Resume.ResumeBuilder()
                        .information(leylaStacy)
                        .addEduBackgnd(edu1)
                        .addEduBackgnd(edu2)
                        .addExpBackgnd(exp1)
                        .build();
            } catch (ResumeIncompleteException e) {
                e.printStackTrace();
            }
        } catch(InvalidDatesException e) {
            e.printStackTrace();
        }

//        ----------------------------------------(E4) Jarred Egbert--------------------------------------------------

        Information jarredEgbert = new Information("Jared", "Egbert", "Male", "jarredeg@gmail.com",
                "+4111111114", LocalDate.of(1986, 10, 7));

        Resume resumeE4JarredEgbert = new Resume();
        try {
            Education edu1 = new Education("Heidelberg American High School", 2002, 8, 1,
                    2006, 6, 1, "highschool", 9.87);
            Education edu2 = new Education("University of Oxford", 2006, 8, 1, 2009,
                    6, 1, "college", 8.75);

            Experience exp1 = new Experience(JPMorgan, "Intern Finance","Finance", 2009, 4,
                    1, 2011, 7, 1);
            Experience exp2 = new Experience(GoldmanSachs, "Analyst", "Finance", 2013, 10,
                    1, 2017, 10, 1);
            Experience exp3 = new Experience(Amazon, "Analyst", "Finance", 2018, 2, 1);

            try {
                resumeE4JarredEgbert = new Resume.ResumeBuilder()
                        .information(jarredEgbert)
                        .addEduBackgnd(edu1)
                        .addEduBackgnd(edu2)
                        .addExpBackgnd(exp1)
                        .addExpBackgnd(exp2)
                        .addExpBackgnd(exp3)
                        .build();
            } catch (ResumeIncompleteException e) {
                e.printStackTrace();
            }
        } catch(InvalidDatesException e) {
            e.printStackTrace();
        }

        // ----------------------------------------(E5) Bethney Kiara--------------------------------------------------

        Information bethneyKiara = new Information("Bethney", "Kiara", "Female", "bethneykg@gmail.com",
                "+4111111115", LocalDate.of(1993, 10, 10));

        Resume resumeE5BethneyKiara = new Resume();
        try {
            Education edu1 = new Education("Aquinas High School", 2011, 10, 1,
                    2015, 7, 1, "highschool", 7.80);
            Education edu2 = new Education("Standford University", 2015, 8, 1, 2019,
                    7, 1, "college", 9.25);

            Experience exp1 = new Experience(Amazon, "Marketing Agent", "Marketing", 2019, 7, 1);

            try {
                resumeE5BethneyKiara= new Resume.ResumeBuilder()
                        .information(bethneyKiara)
                        .addEduBackgnd(edu1)
                        .addEduBackgnd(edu2)
                        .addExpBackgnd(exp1)
                        .build();
            } catch (ResumeIncompleteException e) {
                e.printStackTrace();
            }
        } catch(InvalidDatesException e) {
            e.printStackTrace();
        }

        //----------------------------------------(E6) Rolland Lyla-----------------------------------------------------

        Information rollandLyla = new Information("Rolland", "Lyla", "Female", "rollandly@gmail.com",
                "+4111111116", LocalDate.of(1986, 1, 1));

        Resume resumeE6RollandLyla = new Resume();
        try {
            Education edu1 = new Education("ICS Paris", 2005, 8, 1,
                    2009, 6, 1, "highschool", 8.9);
            Education edu2 = new Education("Ecole Polytechnique", 2009, 8, 1, 2013,
                    6, 1, "college", 9.35);

            Experience exp1 = new Experience(Google, "Intern SDE", "IT", 2013, 7,
                    1, 2013, 10, 1);
            Experience exp2 = new Experience(Softwire, "SDE", "IT", 2014, 9,
                    1, 2015, 1, 1);
            Experience exp3 = new Experience(Bloomberg, "SDE", "IT", 2015, 5,
                    1, 2016, 10, 1);
            Experience exp4 = new Experience(Google, "Senior SDE", "IT", 2017, 3, 1);

            try {
                resumeE6RollandLyla = new Resume.ResumeBuilder()
                        .information(rollandLyla)
                        .addEduBackgnd(edu1)
                        .addEduBackgnd(edu2)
                        .addExpBackgnd(exp1)
                        .addExpBackgnd(exp2)
                        .addExpBackgnd(exp3)
                        .addExpBackgnd(exp4)
                        .build();
            } catch (ResumeIncompleteException e) {
                e.printStackTrace();
            }
        } catch(InvalidDatesException e) {
            e.printStackTrace();
        }

        //----------------------------------------(E7) Steward Goodwin-----------------------------------------------------

        Information stewardGoodwin = new Information("Steward", "Goodwin", "Male", "stewardg@gmail.com",
                "+4111111117", LocalDate.of(1986, 4, 13));

        Resume resumeE7StewardGoodwin = new Resume();
        try {
            Education edu1 = new Education("Tornados High School", 2010, 8, 1,
                    2014, 6, 1, "highschool", 8.05);
            Education edu2 = new Education("University of Groningen", 2014, 10, 1, 2018,
                    7, 1, "college", 7.6);

            Experience exp1 = new Experience(Google, "Manager", "Management", 2018, 7, 1);

            try {
                resumeE7StewardGoodwin = new Resume.ResumeBuilder()
                        .information(stewardGoodwin)
                        .addEduBackgnd(edu1)
                        .addEduBackgnd(edu2)
                        .addExpBackgnd(exp1)
                        .build();
            } catch (ResumeIncompleteException e) {
                e.printStackTrace();
            }
        } catch(InvalidDatesException e) {
            e.printStackTrace();
        }

        //----------------------------------------(E8) Molly Rylie-----------------------------------------------------

        Information mollyRylie = new Information("Molly", "Rylie", "Female", "mollyr@gmail.com",
                "+4111111118", LocalDate.of(1976, 4, 3));

        Resume resumeE8MollyRylie = new Resume();
        try {
            Education edu1 = new Education("Kspace International School", 1998, 8, 1,
                    2002, 7, 1, "highschool", 9.87);
            Education edu2 = new Education("University of Oxford", 2002, 8, 1, 2006,
                    6, 1, "college", 9.93);

            Experience exp1 = new Experience(Google, "Researcher", "Marketing", 2015,
                    10, 1);
            Experience exp2 = new Experience(Softwire, "Marketing", "Marketing",2006,
                    7, 1,2010, 4, 1 );
            Experience exp3 = new Experience(Google,"Researcher", "Marketing", 2011,
                    6, 1, 2012, 10, 1);
            Experience exp4 = new Experience(Amazon, "Researcher", "Marketing", 2013,
                    2, 1, 2014, 5, 1);

            try {
                resumeE8MollyRylie = new Resume.ResumeBuilder()
                        .information(mollyRylie)
                        .addEduBackgnd(edu1)
                        .addEduBackgnd(edu2)
                        .addExpBackgnd(exp1)
                        .addExpBackgnd(exp2)
                        .addExpBackgnd(exp3)
                        .addExpBackgnd(exp4)
                        .build();
            } catch (ResumeIncompleteException e) {
                e.printStackTrace();
            }
        } catch(InvalidDatesException e) {
            e.printStackTrace();
        }

        //----------------------------------------(E9) Morley Denise-----------------------------------------------------

        Information morlyeDenise = new Information("Morley", "Denise", "Female", "morleyd@gmail.com",
                "+4111111119", LocalDate.of(1997, 1, 1));

        Resume resumeE9MorleyDenise = new Resume();
        try {
            Education edu1 = new Education("National High School of Berlin", 2014, 8, 1,
                    2018, 6, 1, "highschool", 10.0);
            Education edu2 = new Education("Jacobs University", 2018, 10, 1, "college", 9.45);

            Experience exp1 = new Experience(Google, "Finance Intern", "Finance", 2020, 7, 1);

            try {
                resumeE9MorleyDenise = new Resume.ResumeBuilder()
                        .information(morlyeDenise)
                        .addEduBackgnd(edu1)
                        .addEduBackgnd(edu2)
                        .addExpBackgnd(exp1)
                        .build();
            } catch (ResumeIncompleteException e) {
                e.printStackTrace();
            }
        } catch(InvalidDatesException e) {
            e.printStackTrace();
        }

        //----------------------------------------(E10) Bryson Reenie-----------------------------------------------------

        Information brysonReenie = new Information("Bryson", "Reenie", "Male", "brysonr@gmail.com",
                "+4111111110", LocalDate.of(1983, 3, 18));

        Resume resumeE10BrysonReenie = new Resume();
        try {
            Education edu1 = new Education("Jamaica Plain High School", 2001, 8, 1,
                    2005, 6, 1, "highschool", 9.5);
            Education edu2 = new Education("Harvard", 2006, 8, 1,2011,
                    6, 1, "college", 9.45);
            Experience exp1 = new Experience(Softwire, "Marketing", "Marketing", 2011, 7,
                    1, 2015, 4, 1);
            Experience exp2 = new Experience(Google, "Marketing", "Marketing", 2015, 10, 1);

            try {
                resumeE10BrysonReenie = new Resume.ResumeBuilder()
                        .information(brysonReenie)
                        .addEduBackgnd(edu1)
                        .addEduBackgnd(edu2)
                        .addExpBackgnd(exp1)
                        .addExpBackgnd(exp2)
                        .build();
            } catch (ResumeIncompleteException e) {
                e.printStackTrace();
            }
        } catch(InvalidDatesException e) {
            e.printStackTrace();
        }

        //----------------------------------------(R1) Jonie Phillip--------------------------------------------------------
        Information joniePhillip = new Information("Jonie", "Phillip", "Male", "jphilip@gmail.com",
                "+4123456789", LocalDate.of(1980, 2, 2));

        Resume resumeR1JoniePhillip = new Resume();
        try {
            Education edu1 = new Education("High School of Brussels", 2000, 8, 1,
                    2004, 6, 1, "highschool", 9.6);
            Education edu2 = new Education("University of Oxford", 2004, 8, 1, 2008,
                    6, 1, "college", 8.8);

            Experience exp1 = new Experience(Google, "Recruiter", "IT", 2015, 10, 1);
            Experience exp2 = new Experience(Softwire, "Recruiter", "IT", 2009, 10,
                    1,2013, 1, 1);

            try {
                resumeR1JoniePhillip = new Resume.ResumeBuilder()
                        .information(joniePhillip)
                        .addEduBackgnd(edu1)
                        .addEduBackgnd(edu2)
                        .addExpBackgnd(exp1)
                        .addExpBackgnd(exp2)
                        .build();
            } catch (ResumeIncompleteException e) {
                e.printStackTrace();
            }
        } catch(InvalidDatesException e) {
            e.printStackTrace();
        }

        //----------------------------------------(R2) Janine Woody--------------------------------------------------------

        Information janineWoody = new Information("Janine", "Woody", "Male", "jwoody@gmail.com",
                "+4123456787", LocalDate.of(1989, 12, 12));

        Resume resumeR2JanineWoody = new Resume();
        try {
            Education edu1 = new Education("Thomas Jefferson High School for Science and Technology", 2006, 8, 1,
                    2010, 6, 1, "highschool", 9.75);
            Education edu2 = new Education("MIT", 2010, 8, 1, 2014,
                    6, 1, "college", 9.8);

            Experience exp1 = new Experience(Google, "Recruiter", "IT", 2012, 1, 1);


            try {
                resumeR2JanineWoody = new Resume.ResumeBuilder()
                        .information(janineWoody)
                        .addEduBackgnd(edu1)
                        .addEduBackgnd(edu2)
                        .addExpBackgnd(exp1)
                        .build();
            } catch (ResumeIncompleteException e) {
                e.printStackTrace();
            }
        } catch(InvalidDatesException e) {
            e.printStackTrace();
        }

        //----------------------------------------(R3) Darrel Lillie--------------------------------------------------------

        Information darrellLillie = new Information("Darrel", "Lillie", "Male", "dlillie@amazon.com",
                "+4333333333", LocalDate.of(1983, 5, 5));

        Resume resumeR3DarrelLillie = new Resume();
        try {
            Education edu1 = new Education("Crestview High School", 2009, 8, 1,
                    2013, 6, 1, "highschool", 8.75);
            Education edu2 = new Education("Bristol University", 2013, 8, 1, 2017,
                    6, 1, "college", 7.8);

            Experience exp1 = new Experience(Amazon, "Recruiter", "IT", 2018, 1, 1);

            try {
                resumeR3DarrelLillie = new Resume.ResumeBuilder()
                        .information(darrellLillie)
                        .addEduBackgnd(edu1)
                        .addEduBackgnd(edu2)
                        .addExpBackgnd(exp1)
                        .build();
            } catch (ResumeIncompleteException e) {
                e.printStackTrace();
            }
        } catch(InvalidDatesException e) {
            e.printStackTrace();
        }

        //----------------------------------------(R4) Damian Bodhi--------------------------------------------------------

        Information damianBodhi = new Information("Damian", "Bodhi", "Male", "dbodhi@amazon.com",
                "+4444444444", LocalDate.of(1988, 6, 29));

        Resume resumeR4DamianBodhi = new Resume();
        try {
            Education edu1 = new Education("Enterprise School", 2007, 8, 1,
                    2011, 6, 1, "highschool", 9.9);
            Education edu2 = new Education("MIT", 2011, 6, 1, 2014,
                    7, 1, "college", 9.65);

            Experience exp1 = new Experience(Amazon, "Recruiter", "IT", 2014, 10, 1);
            Experience exp2 = new Experience(Microsoft, "Recruiter", "IT", 2014, 1,
                    1, 2014, 5, 1);

            try {
                resumeR4DamianBodhi = new Resume.ResumeBuilder()
                        .information(damianBodhi)
                        .addEduBackgnd(edu1)
                        .addEduBackgnd(edu2)
                        .addExpBackgnd(exp1)
                        .addExpBackgnd(exp2)
                        .build();
            } catch (ResumeIncompleteException e) {
                e.printStackTrace();
            }
        } catch(InvalidDatesException e) {
            e.printStackTrace();
        }

        //----------------------------------------(U1) Daniel Edmund--------------------------------------------------------

        Information danielEdmund = new Information("Daniel", "Edmund", "Male", "dedmund@gmail.com",
                "+4444444444", LocalDate.of(1982, 10, 20));

        Resume resumeU1DanielEdmund = new Resume();
        try {
            Education edu1 = new Education("Gilbert Classical Academy", 2003, 9, 1,
                    2011, 6, 1, "highschool", 6.75);
            Education edu2 = new Education("MIT", 2007, 8, 1, 2012,
                    8, 1, "college", 8.8);
            Education edu3 = new Education("MIT", 2015, 8, 1, 2015,
                    8, 1, "masters", 9.35);

            Experience exp1 = new Experience(MIT, "Researcher", "IT", 2015, 5,
                    1, 2016, 6, 1);


            try {
                resumeU1DanielEdmund = new Resume.ResumeBuilder()
                        .information(danielEdmund)
                        .addEduBackgnd(edu1)
                        .addEduBackgnd(edu2)
                        .addEduBackgnd(edu3)
                        .addExpBackgnd(exp1)
                        .build();
            } catch (ResumeIncompleteException e) {
                e.printStackTrace();
            }
        } catch(InvalidDatesException e) {
            e.printStackTrace();
        }

        //----------------------------------------(U2) Julia Matvei--------------------------------------------------------

        Information juliaMatvei = new Information("Julia", "Matvei", "Female", "jmatvei@gmail.com",
                "+4555555555", LocalDate.of(1988, 11, 10));

        Resume resumeU2JuliaMatvei = new Resume();
        try {
            Education edu1 = new Education("Stanton College Preparatory School", 2010, 8,
                    1, 2014, 6, 1, "highschool", 9.2);
            Education edu2 = new Education("University of Warwick", 2014, 10, 1,
                    2018, 6, 1, "college", 9.4);
            Education edu3 = new Education("University of Oxford", 2018, 8, 1,
                    "masters", 10.0);

            Experience exp1 = new Experience(NXP, "SDE", "IT", 2015, 5, 1,
                    2017, 3, 1);


            try {
                resumeU2JuliaMatvei = new Resume.ResumeBuilder()
                        .information(juliaMatvei)
                        .addEduBackgnd(edu1)
                        .addEduBackgnd(edu2)
                        .addEduBackgnd(edu3)
                        .addExpBackgnd(exp1)
                        .build();
            } catch (ResumeIncompleteException e) {
                e.printStackTrace();
            }
        } catch(InvalidDatesException e) {
            e.printStackTrace();
        }

        //----------------------------------------(U3) Tamara Haci--------------------------------------------------------

        Information tamaraHaci = new Information("Tamara", "Haci", "Male", "thaci@gmail.com",
                "+4444444444", LocalDate.of(1988, 2, 15));

        Resume resumeU3TamaraHaci = new Resume();
        try {
            Education edu1 = new Education("Downigntown STEM Academy", 2005, 9, 1,
                    2009, 8, 1, "highschool", 10.0);
            Education edu2 = new Education("Ecole Polytechnique", 2009, 8, 1,
                    2014, 6, 1, "college", 9.1);

            Experience exp1 = new Experience(Microsoft, "SDE", "IT", 2015, 10,
                    1, 2016, 3, 1);
            Experience exp2 = new Experience(JPMorgan, "SDE", "IT", 2016, 6,
                    1, 2017, 11, 1);
            Experience exp3 = new Experience(Bloomberg, "SDE", "IT", 2017, 5,
                    1, 2018, 8, 1);


            try {
                resumeU3TamaraHaci = new Resume.ResumeBuilder()
                        .information(tamaraHaci)
                        .addEduBackgnd(edu1)
                        .addEduBackgnd(edu2)
                        .addExpBackgnd(exp1)
                        .addExpBackgnd(exp2)
                        .addExpBackgnd(exp3)
                        .build();
            } catch (ResumeIncompleteException e) {
                e.printStackTrace();
            }
        } catch(InvalidDatesException e) {
            e.printStackTrace();
        }

        //----------------------------------------(U4) Linette Spartak--------------------------------------------------------

        Information linetteSpartak = new Information("Linette", "Spartak", "Male", "lspartak@amazon.com",
                "+4444444444", LocalDate.of(1998, 8, 5));

        Resume resumeU4LinetteSpartak = new Resume();
        try {
            Education edu1 = new Education("Thomas Jefferson High School for Science and Technology",
                    2014, 8, 1, 2018, 6, 1, "highschool", 8.9);
            Education edu2 = new Education("University of Manchester", 2018, 8, 1,
                    "college", 9.75);

            Experience exp1 = new Experience(Softwire, "Intern SDE", "IT", 2018,
                    5, 1, 2018, 9, 1);
            Experience exp2 = new Experience(Bloomberg, "Intern SDE", "IT", 2018,
                    11, 1, 2019, 11, 1);

            try {
                resumeU4LinetteSpartak = new Resume.ResumeBuilder()
                        .information(linetteSpartak)
                        .addEduBackgnd(edu1)
                        .addEduBackgnd(edu2)
                        .addExpBackgnd(exp1)
                        .addExpBackgnd(exp2)
                        .build();
            } catch (ResumeIncompleteException e) {
                e.printStackTrace();
            }
        } catch(InvalidDatesException e) {
            e.printStackTrace();
        }

        //----------------------------------------(M1) Sundar Pichai--------------------------------------------------------

        Information sundarPichai = new Information("Sundar", "Pichai", "Male", "spichai@gmail.com",
                "+4444444444", LocalDate.of(1972, 7, 12));

        Resume resumeM1SundarPichai = new Resume();
        try {
            Education edu1 = new Education("Thomas Jefferson High School for Science and Technology", 2000,
                    8, 1, 2004, 6, 1, "highschool", 8.9);
            Education edu2 = new Education("University of Manchester", 2004, 8, 1,
                    2008, 6, 1, "college", 9.75);

            Experience exp1 = new Experience(Google, "CEO", 2015, 5, 1);


            try {
                resumeM1SundarPichai = new Resume.ResumeBuilder()
                        .information(sundarPichai)
                        .addEduBackgnd(edu1)
                        .addEduBackgnd(edu2)
                        .addExpBackgnd(exp1)
                        .build();
            } catch (ResumeIncompleteException e) {
                e.printStackTrace();
            }
        } catch(InvalidDatesException e) {
            e.printStackTrace();
        }

        //----------------------------------------(M2) Jeff Bezos--------------------------------------------------------

        Information jeffBezos = new Information("Jeff", "Bezos", "Male", "jbezos@gmail.com",
                "+4444444444", LocalDate.of(1964, 1, 12));

        Resume resumeM2JeffBezos = new Resume();
        try {
            Education edu1 = new Education("Thomas Jefferson High School for Science and Technology", 1982,
                    8, 1, 1986, 6, 1, "highschool", 8.9);
            Education edu2 = new Education("Princeton University", 1986, 8, 1,
                    1990, 6, 1, "college", 9.75);

            Experience exp1 = new Experience(Amazon, "CEO", 1994, 6, 5);


            try {
                resumeM2JeffBezos = new Resume.ResumeBuilder()
                        .information(jeffBezos)
                        .addEduBackgnd(edu1)
                        .addEduBackgnd(edu2)
                        .addExpBackgnd(exp1)
                        .build();
            } catch (ResumeIncompleteException e) {
                e.printStackTrace();
            }
        } catch(InvalidDatesException e) {
            e.printStackTrace();
        }

//      ----------------------------------------Making them employees/users/recruiters/managers-------------------------

        SundarPichai.setResume(resumeM1SundarPichai);
        SundarPichai.setCompany(Google);
        SundarPichai.setSalary(1);

        JeffBezos.setResume(resumeM2JeffBezos);
        JeffBezos.setCompany(Amazon);
        JeffBezos.setSalary(1);

        Employee E1 = new Employee(resumeE1HarmonyLorinda, Amazon, 5000);
        Employee E2 = new Employee(resumeE2ShanaAddy, Amazon, 3000);
        Employee E3 = new Employee(resumeE3LeylaStacy, Amazon, 3500);
        Employee E4 = new Employee(resumeE4JarredEgbert, Amazon, 8500);
        Employee E5 = new Employee(resumeE5BethneyKiara, Amazon, 6000);
        Employee E6 = new Employee(resumeE6RollandLyla, Google, 9000);
        Employee E7 = new Employee(resumeE7StewardGoodwin, Google, 4500);
        Employee E8 = new Employee(resumeE8MollyRylie, Google, 10000);
        Employee E9 = new Employee(resumeE9MorleyDenise, Google, 3500);
        Employee E10 = new Employee(resumeE10BrysonReenie,Google, 10000);

        itAmazon.add(E1);
        managementAmazon.add(E2);
        marketingAmazon.add(E3);
        financeAmazon.add(E4);
        marketingAmazon.add(E5);

        itGoogle.add(E6);
        managementGoogle.add(E7);
        marketingGoogle.add(E8);
        financeGoogle.add(E9);
        marketingGoogle.add(E10);

        Recruiter R1 = new Recruiter(resumeR1JoniePhillip, Google, 8000);
        Recruiter R2 = new Recruiter(resumeR2JanineWoody, Google, 8000);
        Recruiter R3 = new Recruiter(resumeR3DarrelLillie, Amazon, 5000);
        Recruiter R4 = new Recruiter(resumeR4DamianBodhi, Amazon, 9000);

        itGoogle.add(R1);
        itGoogle.add(R2);
        itAmazon.add(R3);
        itAmazon.add(R4);

        Google.add(R1);
        Google.add(R2);
        Amazon.add(R3);
        Amazon.add(R4);

        User U1 = new User(resumeU1DanielEdmund);
        User U2 = new User(resumeU2JuliaMatvei);
        User U3 = new User(resumeU3TamaraHaci);
        User U4 = new User(resumeU4LinetteSpartak);

//        Google.addObserver(U1);
//        Google.addObserver(U2);
//        Google.addObserver(U3);
//        Google.addObserver(U4);
//
//        Amazon.addObserver(U2);
//        Amazon.addObserver(U3);
//        Amazon.addObserver(U4);

        U1.addCompany("Google");
        U2.addCompany("Amazon");
        U2.addCompany("Google");
        U3.addCompany("Amazon");
        U3.addCompany("Google");
        U4.addCompany("Amazon");
        U4.addCompany("Google");

        Application.getInstance().add(U1);
        Application.getInstance().add(U2);
        Application.getInstance().add(U3);
        Application.getInstance().add(U4);
//      ----------------------------------------Making them friends :D-------------------------

        U1.add(U2);
        U1.add(E3);

        U2.add(U1);
        U2.add(E7);
        U2.add(R1);

        U3.add(U4);
        U3.add(E3);

        U4.add(U3);
        U4.add(E10);

        E2.add(E10);
        E2.add(R3);

        E3.add(U1);
        E3.add(U3);
        E3.add(R2);
        E3.add(E6);

        E6.add(E3);
        E6.add(R4);

        E10.add(U4);
        E10.add(E2);

        E7.add(U2);

        R1.add(U2);
        R2.add(E3);
        R3.add(E2);
        R4.add(E6);

//      ----------------------------------------Making them jobs--------------------------------------------------------

        Job jobSDEGoogle = new Job("SDE", Google, true, new Constraint<Integer>(2002, 2020),
                new Constraint<Integer>(2, 6), new Constraint<Double>(8.0, null),
                1, 10000);
        Job jobSDEGoogleIntern = new Job("SDE Intern", Google, true, new Constraint<>(null, null),
                new Constraint<>(0, 2), new Constraint<>(9.0, null), 1, 5000);

        Job jobSDEAmazon = new Job("SDE", Amazon, true, new Constraint<>(2014, 2020), new Constraint<>(1, null),
                new Constraint<>(9.0, null), 1, 12000);
        Job jobSDEAmazonIntern = new Job("SDE Intern", Amazon, true, new Constraint<>(null, null),
                new Constraint<>(0, 2), new Constraint<>(9.35, null), 1, 6000);

        itGoogle.add(jobSDEGoogle);
        itGoogle.add(jobSDEGoogleIntern);

        itAmazon.add(jobSDEAmazon);
        itAmazon.add(jobSDEAmazonIntern);

        Application.getInstance().add(Google);
        Application.getInstance().add(Amazon);

//      --------------------------------------------------Testing----------------------------------------
//        System.out.println("----------------------------------------(E1) Harmony Lorinda------------" +
//                "----------------------------\n");
//        System.out.println(resumeE1HarmonyLorinda);
//        System.out.println("\n");
//
//        System.out.println("----------------------------------------(E2) Shana Addy------------" +
//                "----------------------------\n");
//        System.out.println(resumeE2ShanaAddy);
//        System.out.println("\n");
//
//        System.out.println("----------------------------------------(E3) Leyla Stacy------------" +
//                "----------------------------\n");
//        System.out.println(resumeE3LeylaStacy);
//        System.out.println("\n");
//
//        System.out.println("----------------------------------------(E4) Jarred Egbert------------" +
//                "----------------------------\n");
//        System.out.println(resumeE4JarredEgbert);
//        System.out.println("\n");
//
//        System.out.println("----------------------------------------(E5) Bethney Kiara------------" +
//                "----------------------------\n");
//        System.out.println(resumeE5BethneyKiara);
//        System.out.println("\n");
//
//        System.out.println("----------------------------------------(E6) Rollan Lyla------------" +
//                "----------------------------\n");
//        System.out.println(resumeE6RollandLyla);
//        System.out.println("\n");
//
//        System.out.println("----------------------------------------(E7) Steward Goodwin------------" +
//                "----------------------------\n");
//        System.out.println(resumeE7StewardGoodwin);
//        System.out.println("\n");
//
//        System.out.println("----------------------------------------(E8) Molly Rylie------------" +
//                "----------------------------\n");
//        System.out.println(resumeE8MollyRylie);
//        System.out.println("\n");
//
//        System.out.println("----------------------------------------(E9) Morley Denise------------" +
//                "----------------------------\n");
//        System.out.println(resumeE9MorleyDenise);
//        System.out.println("\n");
//
//        System.out.println("----------------------------------------(E10) Bryson Reenie------------" +
//                "----------------------------\n");
//        System.out.println(resumeE10BrysonReenie);
//        System.out.println("\n");
//
//        System.out.println("----------------------------------------(R1) Jonie Phillip------------" +
//                "----------------------------\n");
//        System.out.println(resumeR1JoniePhillip);
//        System.out.println("\n");
//
//        System.out.println("----------------------------------------(R2) Janine Woody------------" +
//                "----------------------------\n");
//        System.out.println(resumeR2JanineWoody);
//        System.out.println("\n");
//
//        System.out.println("----------------------------------------(R3) Darrel Lillie------------" +
//                "----------------------------\n");
//        System.out.println(resumeR3DarrelLillie);
//        System.out.println("\n");
//
//        System.out.println("----------------------------------------(R4) Damian Bodhi------------" +
//                "----------------------------\n");
//        System.out.println(resumeR4DamianBodhi);
//        System.out.println("\n");
//
//        System.out.println("----------------------------------------(U1) Daniel Edmund------------" +
//                "----------------------------\n");
//        System.out.println(resumeU1DanielEdmund);
//        System.out.println("\n");
//
//        System.out.println("----------------------------------------(U2) Julia Matvei------------" +
//                "----------------------------\n");
//        System.out.println(resumeU2JuliaMatvei);
//        System.out.println("\n");
//
//        System.out.println("----------------------------------------(U3) Tamara Haci------------" +
//                "----------------------------\n");
//        System.out.println(resumeU3TamaraHaci);
//        System.out.println("\n");
//
//        System.out.println("----------------------------------------(U4) Linette Spartak------------" +
//                "----------------------------\n");
//        System.out.println(resumeU4LinetteSpartak);
//        System.out.println("\n");
//
//        System.out.println("----------------------------------------(M1) Sundar Pichai------------" +
//                "-----------------------------------------------------------------------\n");
//        System.out.println(resumeM1SundarPichai);
//        System.out.println("\n");
//
//        System.out.println("----------------------------------------(M2) Jeff Bezos------------" +
//                "----------------------------------------------------------------------\n");
//        System.out.println(resumeM2JeffBezos);
//        System.out.println("\n");
//
//        System.out.println("----------------------------------------Testing methods------------" +
//                "----------------------------------------------------------------------\n");
//
//        System.out.println(Application.getInstance().getJobs(U1.getCompaniesInterestedIn()));
//        System.out.println("U1 meets requirments for SDE Google? " + jobSDEGoogle.meetsRequirments(U1));
//        System.out.println("U1 meets requirments for SDE Google Intern? " + jobSDEGoogleIntern.meetsRequirments(U1) + "\n");
//
//        System.out.println(Application.getInstance().getJobs(U2.getCompaniesInterestedIn()));
//        System.out.println("U2 meets requirments for SDE Google? " + jobSDEGoogle.meetsRequirments(U2));
//        System.out.println("U2 meets requirments for SDE Google Intern? " + jobSDEGoogleIntern.meetsRequirments(U2));
//        System.out.println("U2 meets requirments for SDE Amazon? " + jobSDEAmazon.meetsRequirments(U2));
//        System.out.println("U2 meets requirments for SDE Amazon Intern? " + jobSDEAmazonIntern.meetsRequirments(U2) + "\n");
//
//        System.out.println(Application.getInstance().getJobs(U3.getCompaniesInterestedIn()));
//        System.out.println("U3 meets requirments for SDE Google? " + jobSDEGoogle.meetsRequirments(U3));
//        System.out.println("U3 meets requirments for SDE Google Intern? " + jobSDEGoogleIntern.meetsRequirments(U3));
//        System.out.println("U3 meets requirments for SDE Amazon? " + jobSDEAmazon.meetsRequirments(U3));
//        System.out.println("U3 meets requirments for SDE Amazon Intern? " + jobSDEAmazonIntern.meetsRequirments(U3) + "\n");
//
//        System.out.println(Application.getInstance().getJobs(U4.getCompaniesInterestedIn()));
//        System.out.println("U4 meets requirments for SDE Google? " + jobSDEGoogle.meetsRequirments(U4));
//        System.out.println("U4 meets requirments for SDE Google Intern? " + jobSDEGoogleIntern.meetsRequirments(U4));
//        System.out.println("U4 meets requirments for SDE Amazon? " + jobSDEAmazon.meetsRequirments(U4));
//        System.out.println("U4 meets requirments for SDE Amazon Intern? " + jobSDEAmazonIntern.meetsRequirments(U4) + "\n");

    }
}
