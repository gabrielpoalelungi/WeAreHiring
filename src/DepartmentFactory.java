public class DepartmentFactory {
    public static Department factory(String type) {
        if(type.equals("IT")) {
            IT itDepartment = new IT();
            return itDepartment;
        }
        if(type.equals("Management")) {
            Management managementDepartment = new Management();
            return managementDepartment;
        }
        if(type.equals("Marketing")) {
            Marketing marketingDepartment = new Marketing();
            return marketingDepartment;
        }

        if(type.equals("Finance")) {
            Finance financeDepartment = new Finance();
            return financeDepartment;
        }
        return null;
    }
}
