package Factory.ChainOfResp;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 09 : 01
 * @Description: 经理
 */
public class Manager extends Leader{

    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getLeaveDays() < 10){
            System.out.println("员工："+request.getEmpName()+"请假，天数："+request.getLeaveDays()+"，理由："+request.getReason());
            System.out.println("经理："+this.name+"，审批通过！");
        }else{
            if(this.nextLeader != null){
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
