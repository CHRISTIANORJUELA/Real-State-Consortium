package com.example.real_state_consortium.services.Impl;

public class Laboratory {
    private ExercisesPracticeImpl exercisesPracticeImpl;
    private PaintServiceImpl paintServiceImpl;
    private KitchenServiceImpl kitchenServiceImpl;
    private FloorServiceImpl floorServiceImpl;
    private ToiletServiceImpl toiletServiceImpl;
    private AddAtCarImpl addAtCarImpl;
    private CarServiceImpl carServiceImpl;
    private StructureServiceImpl structureServiceImpl;
    private FinallySellimpl finallySellimpl;
    private AgentServiceImpl agentServiceImpl;
    private LoginServiceImpl loginServiceImpl;

    private RegisterServiceImpl registerServiceImpl;

    public Laboratory(){
        exercisesPracticeImpl = new ExercisesPracticeImpl();
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
    }

    public ExercisesPracticeImpl getExercisesPracticeImpl() {
        return exercisesPracticeImpl;
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
