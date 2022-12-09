package com.example.real_state_consortium.services.Impl;

public class Instances {
    private PaintServiceImpl paintServiceImpl;
    private KitchenServiceImpl kitchenServiceImpl;
    private FloorServiceImpl floorServiceImpl;
    private ToiletServiceImpl toiletServiceImpl;
    private GymServiceImpl gymServiceImpl;
    private AddAtCarImpl addAtCarImpl;
    private CarServiceImpl carServiceImpl;
    private StructureServiceImpl structureServiceImpl;
    private FinallySellimpl finallySellimpl;
    private AgentServiceImpl agentServiceImpl;
    private LoginServiceImpl loginServiceImpl;

    private RegisterServiceImpl registerServiceImpl;

    public Instances(){
        paintServiceImpl = new PaintServiceImpl();
        kitchenServiceImpl = new KitchenServiceImpl();
        floorServiceImpl = new FloorServiceImpl();
        toiletServiceImpl = new ToiletServiceImpl();
        addAtCarImpl = new AddAtCarImpl();
        carServiceImpl = new CarServiceImpl();
        structureServiceImpl = new StructureServiceImpl();
        agentServiceImpl = new AgentServiceImpl();
        finallySellimpl = new FinallySellimpl();
        loginServiceImpl = new LoginServiceImpl();
        registerServiceImpl = new RegisterServiceImpl();
        gymServiceImpl = new GymServiceImpl();
    }
    public PaintServiceImpl getPaintServiceImpl() {
        return paintServiceImpl;
    }

    public KitchenServiceImpl getKitchenServiceImpl() {
        return kitchenServiceImpl;
    }

    public FloorServiceImpl getFloorServiceImpl() {
        return floorServiceImpl;
    }

    public GymServiceImpl getGymServiceImpl(){return gymServiceImpl;}

    public ToiletServiceImpl getToiletServiceImpl() {
        return toiletServiceImpl;
    }
    public AddAtCarImpl getAddAtCarImpl(){
        return addAtCarImpl;
    }

    public CarServiceImpl getCarServiceImpl(){return carServiceImpl;}

    public StructureServiceImpl getStructureServiceImpl(){return structureServiceImpl;}

    public FinallySellimpl getFinallySellimpl(){return finallySellimpl;}

    public AgentServiceImpl getAgentServiceImpl() {return agentServiceImpl;}

    public LoginServiceImpl getLoginServiceImpl(){return loginServiceImpl;}

    public RegisterServiceImpl getRegisterServiceImpl(){return registerServiceImpl;}


}
