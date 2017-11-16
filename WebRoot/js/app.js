var app = "/rushanbus";

function showBus(busId)
{
	winOpen(app+'/Proxy/Servlet?servlet=BusBaseInfo&method=detail4this&id='+busId);
}

function showDriver(driverId)
{
	winOpen(app+'/Proxy/Servlet?servlet=DriverInfo&method=detail4this&id='+driverId);
}

function showBusLine(busLineId)
{
	winOpen(app+'/Proxy/Servlet?servlet=BusLineInfo&method=detail4this&id='+busLineId);
}

function showSchoolLine(id)
{
	winOpen(app+'/Proxy/Servlet?servlet=SchoolBusOperationPlan&method=detail4this&id='+id);
}


function showSchoolLine(schoolLineId)
{
	winOpen(app+'/Proxy/Servlet?servlet=SchoolBusOperationPlan&method=detail4this&id='+schoolLineId);
}

function showMaintain(manitainId)
{
	winOpen(app+'/Proxy/Servlet?servlet=MaintainWoMain&method=detail4this&id='+manitainId);
}

function showEe(eeId)
{
	winOpen(app+'/Proxy/Servlet?servlet=ElecEq&method=detail4this&id='+eeId);
}

function showEg(egId)
{
	winOpen(app+'/Proxy/Servlet?servlet=Extinguisher&method=detail4this&id='+egId);
}

function showOilWear(id)
{
	winOpen(app+'/Proxy/Servlet?servlet=OilWear&method=detail4this&id='+id);
}