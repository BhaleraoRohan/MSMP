package report_generation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DBHandlers.reportDBHandler;

/**
 * Servlet implementation class report1
 */
@WebServlet("/report1")
public class report1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String index = request.getParameter("Index");
		String circle = request.getParameter("circle");
		System.out.println(circle);  
		
		if(circle.equals("Maharashtra ")){
			circle = "Maharashtra & Goa";
		}
		
	//	System.out.println(circle);
		switch(index)
		{
			case "fsc":
			{
				report1data report1data=null;
				List<report1data> report1datas = new ArrayList<report1data>();
				ResultSet providers=null;
				reportDBHandler reportDBHandler =  new reportDBHandler();
				providers =  reportDBHandler.getReportData(1,circle);
				try
				{
					while(providers.next())
					  {
						report1data = new report1data(providers.getString("Zone"),providers.getString("circle"), providers.getString("Technician"), 
								providers.getInt("week29"), providers.getInt("week30"), providers.getInt("week31"), providers.getInt("week32"),
								providers.getInt("week33"), providers.getInt("week34"), providers.getInt("week35"), providers.getInt("week36"), providers.getInt("week37"),
								providers.getInt("week38"), providers.getInt("week39"), providers.getInt("week40"), providers.getInt("week41")
								, providers.getInt("week42"), providers.getInt("week43"), providers.getInt("week44"), providers.getInt("week45")
								, providers.getInt("week46"), providers.getInt("week47"), providers.getInt("week48"), providers.getInt("week49")
								, providers.getInt("week50"), providers.getInt("week51"), providers.getInt("week52"), providers.getInt("week53")
								, providers.getInt("week54"), providers.getInt("week55"), providers.getInt("week56"), providers.getInt("week57")
								, providers.getInt("week58"), providers.getInt("week59"), providers.getInt("week60"));
						report1datas.add(report1data);
					  }
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}finally{
					try {
						reportDBHandler.cleanup();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
				
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String json = gson.toJson(new jsonreport1(report1datas));
				PrintWriter pw = response.getWriter();
				pw.println(json);
				
				break;
			}
			case "bts":
			{
				btsdeviationdata btsdeviationdata=null;
				List<btsdeviationdata> btsdeviationdatas = new ArrayList<btsdeviationdata>();
				ResultSet providers=null;
				reportDBHandler reportDBHandler =  new reportDBHandler();
				providers =  reportDBHandler.getReportData(2,circle);
				try
				{
					while(providers.next())
					  {
						btsdeviationdata = new btsdeviationdata(providers.getString("siteid"), providers.getString("opconame"), providers.getString("circle"),
								providers.getString("zone"), providers.getString("count_ISQ"), providers.getString("count_actual"),
								providers.getString("diff"));
						btsdeviationdatas.add(btsdeviationdata);
					  }
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}finally{
					try {
						reportDBHandler.cleanup();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
				
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String json = gson.toJson(new jsonbtsdeviation(btsdeviationdatas));
				PrintWriter pw = response.getWriter();
				pw.println(json);
				
				break;
			}
			case "node":
			{
				nodedeviationdata nodedeviationdata=null;
				List<nodedeviationdata> nodedeviationdatas = new ArrayList<nodedeviationdata>();
				ResultSet providers=null;
				reportDBHandler reportDBHandler =  new reportDBHandler();
				providers =  reportDBHandler.getReportData(3,circle);
				try
				{
					while(providers.next())
					  {
						nodedeviationdata = new nodedeviationdata(providers.getString("siteid"), providers.getString("opconame"),providers.getString("circle"), providers.getString("zone"),
								providers.getString("count_tridu_ISQ"), providers.getString("count_othernode_ISQ"), providers.getString("count_triduactual"),
								providers.getString("count_othernodeuactual"),providers.getString("diff_tridu"), providers.getString("diff_node"));
						nodedeviationdatas.add(nodedeviationdata);
					  }
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}finally{
					try {
						reportDBHandler.cleanup();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
				
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String json = gson.toJson(new jsonnodedeviation(nodedeviationdatas));
				PrintWriter pw = response.getWriter();
				pw.println(json);
				
				break;
			}
			case "radio":
			{
				radiodeviationdata radiodeviationdata=null;
				List<radiodeviationdata> radiodeviationdatas = new ArrayList<radiodeviationdata>();
				ResultSet providers=null;
				reportDBHandler reportDBHandler =  new reportDBHandler();
				providers =  reportDBHandler.getReportData(4,circle);
				try
				{
					while(providers.next())
					  {
						radiodeviationdata = new radiodeviationdata(providers.getString("siteid"), providers.getString("opconame"), providers.getString("circle"),providers.getString("zone"), 
								providers.getString("Rcount_Act"), providers.getString("Rcount_Sys"), providers.getString("diffRCount"));
						radiodeviationdatas.add(radiodeviationdata);
					  }
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}finally{
					try {
						reportDBHandler.cleanup();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
				
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String json = gson.toJson(new jsonradiodeviation(radiodeviationdatas));
				PrintWriter pw = response.getWriter();
				pw.println(json);
				
				break;
			}
			case "mw":
			{
				mwdeviationdata mwdeviationdata=null;
				List<mwdeviationdata> mwdeviationdatas = new ArrayList<mwdeviationdata>();
				ResultSet providers=null;
				reportDBHandler reportDBHandler =  new reportDBHandler();
				providers =  reportDBHandler.getReportData(5,circle);
				try
				{
					while(providers.next())
					  {
						mwdeviationdata = new mwdeviationdata(
								providers.getString("siteid"),
								providers.getString("opcoName"),
								providers.getString("circle"),
								providers.getString("zone"),
								providers.getString("MWType_03"),
								providers.getString("MWType_06"),
								providers.getString("MWType_09"),
								providers.getString("MWType_12"),
								providers.getString("MWType_18"),
								providers.getString("MWType_24"),
								providers.getString("MWType_3"),
								providers.getString("TYPE_03"),
								providers.getString("TYPE_06"),
								providers.getString("TYPE_09"),
								providers.getString("TYPE_12"),
								providers.getString("TYPE_18"),
								providers.getString("TYPE_24"),
								providers.getString("TYPE_3"),
								providers.getString("diff_03"),
								providers.getString("diff_06"),
								providers.getString("diff_09"),
								providers.getString("diff_12"),
								providers.getString("diff_18"),
								providers.getString("diff_24"),
								providers.getString("diff_3"));
						mwdeviationdatas.add(mwdeviationdata);
					  }
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}finally{
					try {
						reportDBHandler.cleanup();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
				
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String json = gson.toJson(new jsonmwdeviation(mwdeviationdatas));
				PrintWriter pw = response.getWriter();
				pw.println(json);
				
				break;
			}
			
			case "nodeio":
			{
				nodeInOut nodeInOut=null;
				List<nodeInOut> nodeInOutdatas = new ArrayList<nodeInOut>();
				ResultSet providers=null;
				reportDBHandler reportDBHandler =  new reportDBHandler();
				providers =  reportDBHandler.getReportData(6,circle);
				try
				{
					while(providers.next())
					  {
						nodeInOut = new nodeInOut(providers.getString("siteid"),
								providers.getString("opconame"),
								providers.getString("NODEMAKE"),
								providers.getString("NODEMAKE"),
								providers.getString("NODELOCATION"),
								providers.getString("NODESPACE")
								);
						nodeInOutdatas.add(nodeInOut);
					  }
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}finally{
					try {
						reportDBHandler.cleanup();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
				
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String json = gson.toJson(new jsonNodeInOut(nodeInOutdatas));
				PrintWriter pw = response.getWriter();
				pw.println(json);
				
				break;
			}
			case "btsio":
			{
				btsInOut btsInOut;
				List<btsInOut> btsInOutdatas = new ArrayList<btsInOut>();
				ResultSet providers=null;
				reportDBHandler reportDBHandler =  new reportDBHandler();
				providers =  reportDBHandler.getReportData(7,circle);
				try
				{
					while(providers.next())
					  {
						btsInOut = new btsInOut(providers.getString("siteid"),
								providers.getString("opconame"),
								providers.getString("BTSMAKE"),
								providers.getString("BTSMODAL"),
								providers.getString("BTSSTACKON"),
								providers.getString("BTSTYPE")
								);
						btsInOutdatas.add(btsInOut);
					  }
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}finally{
					try {
						reportDBHandler.cleanup();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
				
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String json = gson.toJson(new jsonBtsInOut(btsInOutdatas));
				PrintWriter pw = response.getWriter();
				pw.println(json);
				
				break;
			}
			case "Donesites":
			{
				System.out.println("in done sites");
				sitedetailsdata site;
				List<sitedetailsdata> sitedatas = new ArrayList<sitedetailsdata>();
				ResultSet rs=null;
				reportDBHandler reportDBHandler =  new reportDBHandler();
				rs =  reportDBHandler.getReportData(8,circle);
				try
				{
					while(rs.next())
					  {
						
						//String sDate = new SimpleDateFormat("MM/dd/yyyy").format(rs.getDate("date"));
						String sDate = rs.getDate("date").toString();
						site = new sitedetailsdata(rs.getString("siteid"),								
								rs.getString("Circle"),
								rs.getString("zone"),
								rs.getString("fscname"),"hello"
							);
						sitedatas.add(site);
					  }
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}finally{
					try {
						reportDBHandler.cleanup();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
				
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String json = gson.toJson(new jsonsitedetails(sitedatas));
				PrintWriter pw = response.getWriter();
				pw.println(json);
				
				break;
			}
			default:
				break;
		}
		
		
		
	}

}
