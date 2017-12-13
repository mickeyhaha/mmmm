package com.antbox.rfidmachine.service;

import java.util.List;

public abstract interface AntBoxService
{
  public abstract boolean isOpened();
  
  public abstract void open();
  
  public abstract void close();
  
  public abstract List<String> inventory(String paramString);
  
  public abstract void setInventoryTimeSeconds(int paramInt);
}


/* Location:              D:\antbox-rfid-machine.jar!\com\antbox\rfidmachine\service\AntBoxService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */