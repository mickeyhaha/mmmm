/*     */ package com.antbox.rfidmachine.swing;
/*     */ 
/*     */ import com.antbox.common.RestResult;
/*     */ import com.antbox.domain.Merchant;
/*     */ import com.antbox.domain.RfidMachine;
/*     */ import com.antbox.rfidmachine.dto.UserDto;
/*     */ import com.antbox.rfidmachine.helper.AntboxrHelper;
/*     */ import com.antbox.rfidmachine.helper.RetrofitHelper;
/*     */ import com.antbox.rfidmachine.service.LocalService;
/*     */ import java.awt.Container;
/*     */ import java.awt.Window;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPasswordField;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.SwingUtilities;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import retrofit2.Call;
/*     */ import retrofit2.Response;
/*     */ 
/*     */ public class LoginTable extends javax.swing.JFrame
/*     */ {
/*  28 */   Container con = getContentPane();
/*     */   
/*     */   private JTextField username;
/*     */   private JPasswordField password;
/*     */   private JLabel userNameText;
/*     */   private JLabel passwordText;
/*     */   private JButton butLogin;
/*     */   private JButton butLoginOut;
/*     */   
/*     */   public LoginTable()
/*     */   {
/*  39 */     setTitle("欢迎登录 - 蚂蚁盒子一体机客户端");
/*  40 */     init();
/*     */     
/*  42 */     setLayout(null);
/*     */     
/*  44 */     setBounds(0, 0, 300, 250);
/*     */     
/*  46 */     setResizable(false);
/*     */     
/*  48 */     setLocationRelativeTo(null);
/*     */     
/*  50 */     setDefaultCloseOperation(3);
/*     */     
/*  52 */     setVisible(true);
/*     */     try
/*     */     {
/*  55 */       Response<RestResult<RfidMachine>> resultResponse = RetrofitHelper.getLocalService().downloadNewestRfidVersion().execute();
/*  56 */       String resultCode = ((RestResult)resultResponse.body()).getCode();
/*  57 */       RfidMachine version = (RfidMachine)((RestResult)resultResponse.body()).data;
/*  58 */       if ((resultCode.equals(RestResult.CD1[0])) && (version != null) && (!version.getEdition().equals("V1-03"))) {
/*  59 */         int code = JOptionPane.showConfirmDialog(null, "立即更新?", "更新提示", 0);
/*  60 */         if (code == 0) {
/*  61 */           SwingUtilities.windowForComponent(this.con).dispose();
/*  62 */           DownloadJarTable localDownloadJarTable = new DownloadJarTable(version.getNewDependJar(), version.getOldDependJar());
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  66 */       e.printStackTrace();
/*  67 */       JOptionPane.showMessageDialog(null, "系统异常，请联系技术人员");
/*  68 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void init()
/*     */   {
/*  77 */     this.userNameText = new JLabel();
/*     */     
/*  79 */     this.username = new JTextField();
/*  80 */     this.username.setBounds(100, 50, 150, 20);
/*     */     
/*     */ 
/*  83 */     this.userNameText = new JLabel("用户名:");
/*  84 */     this.userNameText.setBounds(40, 50, 70, 25);
/*     */     
/*     */ 
/*  87 */     this.password = new JPasswordField();
/*  88 */     this.password.setBounds(100, 80, 150, 20);
/*     */     
/*  90 */     this.passwordText = new JLabel("密  码:");
/*  91 */     this.passwordText.setBounds(40, 80, 70, 25);
/*     */     
/*     */ 
/*  94 */     this.butLoginOut = new JButton("退出");
/*  95 */     this.butLoginOut.setBounds(200, 160, 65, 20);
/*     */     
/*  97 */     this.butLogin = new JButton("登录");
/*  98 */     this.butLogin.setBounds(30, 160, 65, 20);
/*     */     
/*     */ 
/* 101 */     this.butLogin.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/* 104 */         String loginName = LoginTable.this.username.getText();
/* 105 */         char[] pwd = LoginTable.this.password.getPassword();
/* 106 */         if (StringUtils.isBlank(loginName)) {
/* 107 */           JOptionPane.showMessageDialog(null, "登录名不能为空");
/* 108 */           return;
/*     */         }
/* 110 */         if ((pwd == null) || (pwd.length < 0)) {
/* 111 */           JOptionPane.showMessageDialog(null, "密码不能为空");
/* 112 */           return;
/*     */         }
/*     */         
/* 115 */         UserDto dto = new UserDto();
/* 116 */         dto.setUsername(loginName);
/* 117 */         dto.setPassword(String.valueOf(pwd));
/*     */         
/*     */         try
/*     */         {
/* 121 */           Response<RestResult<List<Merchant>>> jsonResultResponse = RetrofitHelper.getLocalService().selectMerchant(dto.getUsername(), dto.getPassword()).execute();
/* 122 */           String resultCode = ((RestResult)jsonResultResponse.body()).getCode();
/*     */           List<Merchant> merchantList;
/* 124 */           if (resultCode.equals(RestResult.CD1[0])) {
/* 125 */             merchantList = (List)((RestResult)jsonResultResponse.body()).data;
/*     */           } else {
/* 127 */             JOptionPane.showMessageDialog(null, ((RestResult)jsonResultResponse.body()).getDesc()); return;
/*     */           }
/*     */           List<Merchant> merchantList;
/* 130 */           if (merchantList.size() < 0) {
/* 131 */             JOptionPane.showMessageDialog(null, "此账号无效");
/* 132 */             return;
/*     */           }
/*     */           
/* 135 */           SwingUtilities.windowForComponent(LoginTable.this.con).dispose();
/* 136 */           if (merchantList.size() == 1) {
/* 137 */             dto.setDomain(((Merchant)merchantList.get(0)).getDomain());
/* 138 */             UserDto userDto = AntboxrHelper.SINGLETON.merchantLogin(dto, RetrofitHelper.getLocalService());
/* 139 */             if (StringUtils.isBlank(userDto.getAccessToken())) {
/* 140 */               JOptionPane.showMessageDialog(null, "登陆失败");
/* 141 */               return;
/*     */             }
/*     */             
/* 144 */             AntboxTable table = new AntboxTable();
/* 145 */             table.showBody(dto, merchantList, (Merchant)merchantList.get(0));
/*     */           }
/* 147 */           if (merchantList.size() > 1) {
/* 148 */             SelectMerchantTable merchantTable = new SelectMerchantTable();
/* 149 */             merchantTable.initMerchantDomains(dto, merchantList);
/*     */           }
/*     */         } catch (Exception ex) {
/* 152 */           ex.printStackTrace();
/* 153 */           JOptionPane.showMessageDialog(null, "系统异常，请联系技术人员");
/* 154 */           return;
/*     */         }
/*     */         
/*     */       }
/*     */       
/*     */ 
/* 160 */     });
/* 161 */     this.butLoginOut.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/* 164 */         System.exit(0);
/*     */       }
/*     */       
/*     */ 
/* 168 */     });
/* 169 */     this.con.add(this.userNameText);
/* 170 */     this.con.add(this.passwordText);
/* 171 */     this.con.add(this.butLogin);
/* 172 */     this.con.add(this.butLoginOut);
/* 173 */     this.con.add(this.username);
/* 174 */     this.con.add(this.password);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 181 */     LoginTable loginTable = new LoginTable();
/*     */   }
/*     */ }


/* Location:              D:\antbox-rfid-machine.jar!\com\antbox\rfidmachine\swing\LoginTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */