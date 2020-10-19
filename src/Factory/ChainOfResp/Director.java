package Factory.ChainOfResp;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 09 : 01
 * @Description: 主任
 */
public class Director extends Leader{

    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getLeaveDays() < 3){
            System.out.println("员工："+request.getEmpName()+"请假，天数："+request.getLeaveDays()+"，理由："+request.getReason());
            System.out.println("主任："+this.name+"，审批通过！");
        }else{
            if(this.nextLeader != null){
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
